lazy val root = (project in file("."))
  .settings(
    organization := "com.example",
    name := "sample-project",
    scalaVersion := "2.12.2",
    version := "0.1.0",
    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.3" % "test")
  )