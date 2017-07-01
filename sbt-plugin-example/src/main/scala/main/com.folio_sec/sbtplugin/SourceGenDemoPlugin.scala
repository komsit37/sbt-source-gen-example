package main.com.folio_sec.sbtplugin

import sbt.{File, _}
import sbt.Keys._

object SourceGenDemoPlugin extends AutoPlugin {
  // by defining autoImport, the settings are automatically imported into user's `*.sbt`
  object autoImport {
    // configuration points, like the built-in `version`, `libraryDependencies`, or `compile`
    val demoGen = taskKey[Seq[File]]("demo gen")
    val demoGenOutputFolder = SettingKey[File](
      "demo-gen-output-folder",
      "output folder for generated files (defaults to sourceManaged)"
    )

    // default values for the tasks and settings
    lazy val defaultDemoGenSettings: Seq[Def.Setting[_]] = Seq(
      demoGen := {
        SourceGen(demoGenOutputFolder.value)
      },
      demoGenOutputFolder in Compile := (sourceManaged in Compile).value / "gen-demo",
      demoGenOutputFolder in Test := (sourceManaged in Test).value / "gen-demo"
    )
  }

  import autoImport._
  override def requires = sbt.plugins.JvmPlugin

  // This plugin is automatically enabled for projects which are JvmPlugin.
  override def trigger = allRequirements

  // a group of settings that are automatically added to projects.
  override val projectSettings =
    inConfig(Compile)(defaultDemoGenSettings) ++
      inConfig(Test)(defaultDemoGenSettings)
}

object SourceGen {
  def apply(base: File): Seq[File] = {
    val file = base / "Test.scala"
    IO.write(file, """object Test extends App { println("Hi") }""")
    Seq(file)
  }
}