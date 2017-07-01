import Dependencies._

lazy val baseSettings = Seq(
  organization := "com.folio_sec",
  version := "0.1.0-SNAPSHOT",
  scalacOptions ++= _scalaOptions,
  incOptions := sbt.inc.IncOptions.Default,
  transitiveClassifiers in Global := Seq(Artifact.SourceClassifier),
  publishMavenStyle := true,
  pomIncludeRepository := (_ => false),
  scalafmtOnCompile := true,
  pomExtra := _pomExtra
)

lazy val `sbt-plugin-example` = (project in file("sbt-plugin-example"))
  .settings(baseSettings)
  .settings(
    name := "sbt-plugin-example",
    scalaVersion := "2.10.6",
    crossScalaVersions := Seq("2.10.6"),
    sbtPlugin := true,
    libraryDependencies ++= Seq(
      scalaTest       % Test//,
      // ant             % Compile,
      // reladomogen     % Compile,
      // reladomogenUtil % Compile
    )
  )

lazy val gitRepositoryName = "sbt-plugin-seed"
lazy val _scalaOptions     = Seq("-unchecked", "-deprecation", "-feature")
lazy val _pomExtra =
  <url>https://github.com/folio-sec/${gitRepositoryName}</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:folio-sec/${gitRepositoryName}.git</url>
        <connection>scm:git:git@github.com:folio-sec/${gitRepositoryName}.git</connection>
      </scm>
      <developers>
      </developers>
