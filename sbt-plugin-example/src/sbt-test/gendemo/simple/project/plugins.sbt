sys.props.get("plugin.version") match {
  case Some(x) =>
    addSbtPlugin("com.folio_sec"   % "sbt-plugin-example" % x)
  case _ => sys.error("""|The system property 'plugin.version' is not defined.
                         |Specify this property using the scriptedLaunchOpts -Dplugin.version.""".stripMargin)
}
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC6")