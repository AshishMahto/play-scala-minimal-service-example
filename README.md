# Play service example

This is a basic example demonstrating the `PlayService` sbt plugin for creating simple Play-based microservices. This plugin uses the standard maven layout, not the traditional Play web layout.

It uses a custom application loader, and for demonstration purposes all the code is in a single file, `AppComponents.scala`. The `RoutesCompiler` plugin can be added if you wish to compile a router using the Play routes syntax (place the file in `src/main/resources/`).
