package de.atextor.metamapper

case class StepsAggregator(description: String = "", f: (String => String) = identity)

class StepList(val input: String, val output: String, val l: Option[List[Step]]) {
  override def toString = l.map { stepList =>
    s"Input: ${input} :: Output: ${output} :: Steps: ${Mapper.foldSteps(stepList).description}"
  }.getOrElse(s"No way from ${input} to ${output} found")
}
  
object Mapper {
  def foldSteps(l: List[Step]): StepsAggregator = {
    l.foldLeft(StepsAggregator()) { case (agg, step) =>
      val initial = if (agg.description.isEmpty) "" else s"${agg.description}, "
      agg.copy(description = s"${initial}${step.name}", agg.f.andThen(step.f))
    }
  }
  
  def apply(input: String, output: String, maxDepth: Int = 7): StepList = new StepList(input, output,
    Stream.from(1).flatMap(d => Functions.steps.combinations(d).toList.flatMap(_.permutations)).takeWhile(_.size <= maxDepth).find { stepList => 
      foldSteps(stepList).f(input) == output
    })
}