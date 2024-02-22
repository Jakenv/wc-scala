package org.example.wcscala
import scala.io.Source
import mainargs._

object Main {
  private def printLines(file: String): Unit =
    val source = Source.fromFile(file)
    val line = source.getLines().size
    println(s"Lines: $line")

  private def printWords(file: String): Unit =
    val source = Source.fromFile(file)
    val line = source.getLines()
    val words = line.flatMap(_.split("\\s+")).length
    println(s"Words: $words")

  private def printChars(file: String): Unit =
    val source = Source.fromFile(file)
    val line = source.getLines()
    val chars = line.mkString.length
    println(s"Chars: $chars")
  
  @main
  def wcLines(@arg(short = 'f', name = "file", doc = "File path")
              file: String,
              @arg(short = 'l', name = "lines", doc = "Print number of lines in file")
              lines: Flag,
              @arg(short = 'c', name = "char", doc = "Print number of char in file")
              char: Flag,
              @arg(short = 'w', name = "words", doc = "Print number of words in file")
              words: Flag): Unit =
    if lines.value then
      printLines(file: String)

    if words.value then
      printWords(file: String)
      
    if char.value then
      printChars(file: String)

  def main(args: Array[String]): Unit = ParserForMethods(this).runOrExit(args)
}