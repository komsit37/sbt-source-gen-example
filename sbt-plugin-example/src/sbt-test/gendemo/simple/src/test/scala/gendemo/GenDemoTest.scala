package gendemo

import org.scalatest.FunSuite
import gendemo.Test2

class GenDemoTest extends FunSuite {
  test("generated Test2 object with value") {
    assert(Test2.x == 1, "generated Test2 object does not have variable x with expected value '1'")
  }
}