package de.atextor.metamapper

import java.io.Console
import java.io.BufferedReader
import java.io.InputStreamReader

object Main extends App {
  val b = new BufferedReader(new InputStreamReader(System.in))
  while (true) {
    print("Input: ")
    val input = b.readLine
    print("Output: ")
    val output = b.readLine
    println(Mapper(input, output, 4))
  }

}