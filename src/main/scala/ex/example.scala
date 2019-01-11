package ex

import scala.io.Source

/**
  * @author: kexi
  * @date: 2019/1/11
  */
object example {
  def main(args: Array[String]): Unit = {
    read(Array("build.sbt"))
  }

  def array(): Unit ={
    val greetStrings =new Array[String](3)
    greetStrings(0)="Hello"
    greetStrings(1)=","
    greetStrings(2)="world!\n"
    for(i <- 0 to 2)
      print(greetStrings(i))
  }

  def list(): Unit ={
    val oneTwo = List(1,2)
    val threeFour = List(3,4)
    val oneTwoThreeFour=oneTwo ::: threeFour
    println (oneTwo + " and " + threeFour + " were not mutated.")
    println ("Thus, " + oneTwoThreeFour + " is a new list")
  }

  def list2: Unit ={
    val oneTowThree = 1 :: 2 ::3 :: Nil
    println(oneTowThree)
  }

  def tuples: Unit ={
    val pair=(99,"Luftballons")
    println(pair._1)
    println(pair._2)
  }

  def set: Unit ={
    var jetSet = Set ("Boeing","Airbus")
    jetSet +="Lear"
    println(jetSet.contains("Cessna"))
  }

  def map: Unit ={
    val romanNumeral = Map ( 1 -> "I" , 2 -> "II",
      3 -> "III", 4 -> "IV", 5 -> "V")
    println (romanNumeral(4))
  }

  def printArgs ( args: Array[String]) : Unit ={
    args.foreach(println)
  }

  def read(args: Array[String]): Unit ={
    if (args.length >0 ){
      for( line <- Source.fromFile(args(0)).getLines())
        println(line.length + " " + line)
    }
    else
      Console.err.println("Please enter filename")
  }
}
