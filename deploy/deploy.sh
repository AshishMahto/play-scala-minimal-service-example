if [[ ! -f app.yaml ]]; then
  echo "could not find app.yaml, make sure you're in the right directory"
  exit 1
fi

( cd ..; sbt assembly )
mv ../target/scala-2.13/root-assembly-0.1.0-SNAPSHOT.jar ./example-server.jar

if [[ -z "$1" ]]; then
  gcloud app deploy
else
  gcloud app deploy --project="$1"
fi
