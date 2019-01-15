package ex

import scala.collection.mutable.ArrayBuffer

/**
  * @author: kexi
  * @date: 2019/1/14
  */
abstract class IntQueue {
  def get():Int
  def put(x:Int)
}

class BasicIntQueue extends IntQueue{
  private val buf =new ArrayBuffer[Int]
  def get()= buf.remove(0)
  def put(x:Int) { buf += x }
}
