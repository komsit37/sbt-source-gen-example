package main.com.folio_sec.sbtplugin

import sbt.{File, _}
import sbt.Keys.{sourceGenerators, _}

object SourceGenDemoPlugin extends AutoPlugin {
  // by defining autoImport, the settings are automatically imported into user's `*.sbt`
  object autoImport {
    // configuration points, like the built-in `version`, `libraryDependencies`, or `compile`
    val genDemo = taskKey[Seq[java.io.File]]("gen-demo")
    val genDemoOutputFolder = SettingKey[java.io.File](
      "gen-demo-output-folder",
      "output folder for generated files (defaults to sourceManaged)"
    )

    // default values for the tasks and settings
    lazy val defaultDemoGenSettings: Seq[Def.Setting[_]] = Seq(
      genDemoOutputFolder in Compile := (sourceManaged in Compile).value / "gendemo",
      genDemoOutputFolder in Test := (sourceManaged in Test).value / "gendemo",
      genDemo := {
        SourceGen(genDemoOutputFolder.value)
      }
      ,sourceGenerators += genDemo.taskValue
    )
  }

  import autoImport._
  override def requires = sbt.plugins.JvmPlugin

  // This plugin is automatically enabled for projects which are JvmPlugin.
  override def trigger = allRequirements

  // a group of settings that are automatically added to projects.
  override val projectSettings =
    inConfig(Compile)(defaultDemoGenSettings) //++
//      inConfig(Test)(defaultDemoGenSettings)
}

object SourceGen {
  def apply(base: File): Seq[File] = {
    println(s"Generating sources to ${base.getAbsoluteFile.getAbsolutePath}...")
    val file = base / "Test1.scala"
    IO.write(file,
             """package gendemo
        |object Test1 extends App { println("Hi") }""".stripMargin)
    val file2 = base / "Test2.scala"
    IO.write(file2,
             """package gendemo
        |object Test2 { val x = 1 }""".stripMargin)
    Seq(file, file2)
  }
}
