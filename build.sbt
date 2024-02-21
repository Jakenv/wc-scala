
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.0"
exportJars := true

Compile / mainClass := Some("org.example.wcscala.Main")


lazy val root = (project in file("."))
  .settings(
    name := "OpenFile",
    idePackagePrefix := Some("org.example.wcscala"),
    libraryDependencies += "com.lihaoyi" %% "mainargs" % "0.6.2"
  )
