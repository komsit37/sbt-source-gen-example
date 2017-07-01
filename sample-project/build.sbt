
lazy val root = (project in file("."))
  .settings(
    organization := "com.example",
    name := "sample-project",
    scalaVersion := "2.12.2",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      // "org.mariadb.jdbc"          % "mariadb-java-client"    % "2.0.2",
      // "com.folio_sec"             %% "reladomo-scala-common" % "0.1.0-SNAPSHOT",
      // "com.goldmansachs.reladomo" % "reladomo"               % reladomoVersion,
      // "com.goldmansachs.reladomo" % "reladomo-serial"        % reladomoVersion % "test",
      // "com.goldmansachs.reladomo" % "reladomo-test-util"     % reladomoVersion % "test",
      // "org.scalikejdbc"           %% "scalikejdbc"           % "3.0.0" % "test",
      // "com.h2database"            % "h2"                     % "1.4.196" % "test",
      "org.scalatest"             %% "scalatest"             % "3.0.3" % "test"
    ),
    unmanagedSourceDirectories in Compile += baseDirectory.value / "target/reladomo",
    obfuscateLiterals in obfuscate := true
    // reladomoScalaApiFutureType := "twitter",
    // scalafmtOnCompile := true,
    // compile in Compile := (compile in Compile).dependsOn(reladomoGen in Compile).value
  )
  // .enablePlugins(ReladomoPlugin)
