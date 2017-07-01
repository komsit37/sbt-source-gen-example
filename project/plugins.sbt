libraryDependencies += "org.scala-sbt" % "scripted-plugin" % sbtVersion.value

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC5")
addSbtPlugin("com.lucidchart"  % "sbt-scalafmt" % "1.7")
addSbtPlugin("com.jsuereth"    % "sbt-pgp"      % "1.0.0")
addSbtPlugin("org.xerial.sbt"  % "sbt-sonatype" % "1.1")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
