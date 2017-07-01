import sbt._

object Dependencies {
  lazy val reladomoVersion = "16.3.0"
  lazy val twitterUtilCore = "com.twitter" %% "util-core" % "6.45.0"
  lazy val reladomo        = "com.goldmansachs.reladomo" % "reladomo" % reladomoVersion
  lazy val reladomogen     = "com.goldmansachs.reladomo" % "reladomogen" % reladomoVersion
  lazy val reladomogenUtil = "com.goldmansachs.reladomo" % "reladomo-gen-util" % reladomoVersion
  lazy val scalikejdbc     = "org.scalikejdbc" %% "scalikejdbc" % "3.0.0"
  lazy val h2              = "com.h2database" % "h2" % "1.4.195"
  lazy val logbackClassic  = "ch.qos.logback" % "logback-classic" % "1.2.3"

  // reladomo generator depends on ant
  lazy val ant       = "org.apache.ant" % "ant"        % "1.10.1"
  lazy val scalaTest = "org.scalatest"  %% "scalatest" % "3.0.3"
}
