scalaVersion := "2.13.7"
lazy val root = (project in file(".")).enablePlugins(PlayService).settings(
)
assembly / mainClass := Some("play.core.server.ProdServerStart")
//fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value),
assembly / assemblyMergeStrategy := {
  // https://github.com/sbt/sbt-assembly/issues/391#issuecomment-981987422
  case PathList("module-info.class") => MergeStrategy.discard
  // https://stackoverflow.com/a/46871844
  case PathList("META-INF", _*) => MergeStrategy.discard
  
  // https://www.playframework.com/documentation/2.8.16/Deploying#Using-the-sbt-assembly-plugin
  case manifest if manifest.contains("MANIFEST.MF") =>
    // We don't need manifest files since sbt-assembly will create
    // one with the given settings
    MergeStrategy.discard
  case referenceOverrides if referenceOverrides.contains("reference-overrides.conf") =>
    // Keep the content for all reference-overrides.conf files
    MergeStrategy.concat
  case x =>
    // For all the other files, use the default sbt-assembly merge strategy
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}
