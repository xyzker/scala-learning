package ex

/**
  * @author: kexi
  * @date: 2019/1/14
  */
class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}
