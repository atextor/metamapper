package de.atextor.metamapper

class Process

class Step(val name: String, val f: String => String) extends Process {
  override def toString = s"Step(${name})"
}

object Functions {
  val steps = List(
    new Step("identity", identity[String]),
    new Step("lowercase", (s: String) => s.toLowerCase),
    new Step("uppercase", (s: String) => s.toUpperCase),
    new Step("capitalize", (s: String) => s.capitalize),
    new Step("reverse", (s: String) => s.reverse),
    new Step("trim", (s: String) => s.trim),
    new Step("space to underscore", (s: String) => s.replace(" ", "_"))
  )
}
