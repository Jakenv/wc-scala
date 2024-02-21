package org.example.wcscala

import scala.io.Source
import mainargs._

object Main {
  def printLines(file: String): Unit =
    val source = Source.fromFile(file)
    val line = source.getLines().size
    println(s"Lines: $line")

  def printWords(file: String): Unit =
    val source = Source.fromFile(file)
    val line = source.getLines()
    val words = line.flatMap(_.split("\\W+")).foldLeft(Map.empty[String, Int]) { (acc, words) =>
      acc + (words -> (acc.getOrElse(words, 0) + 1))
    }.values.sum
    println(s"Words: $words")

  @main
  def wcLines(@arg(short = 'f', name = "file", doc = "File path")
              file: String,
              @arg(short = 'l', name = "lines", doc = "Print number of lines in file")
              lines: Flag,
              @arg(short = 'w', name = "words", doc = "Print number of words in file")
              words: Flag): Unit =
    if lines.value then
      printLines(file: String)

    if words.value then
      printWords(file: String)

  def main(args: Array[String]): Unit = ParserForMethods(this).runOrExit(args)
}