package de.atextor.metamapper

import org.scalatest.Matchers
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunctionsTest extends FlatSpec with Matchers {
  "Simple: Identity" should "work" in {
    val result = Mapper(input = "FOO", output = "FOO", maxDepth = 1)
    result.l should not be (None)
    println(result)
  }
  
  "Simple: Chaining depth 2" should "work" in {
    val result = Mapper(input = "FOO", output = "oof", maxDepth = 2)
    result.l should not be (None)
    println(result)
  }
  
  "Simple: Chaining depth 3" should "work" in {
    val result = Mapper(input = "FOO", output = "Oof", maxDepth = 3)
    result.l should not be (None)
    println(result) 
  }
  
  "Functions" should "work" in {
    val input = """<something>FOO</something>"""
    val output = """{ "Key": "something", "Value": "FOO" }"""
    
  }
}