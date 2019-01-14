package ex

/**
  * @author: kexi
  * @date: 2019/1/14
  */
object Element {
  private class ArrayElement(val contents: Array[String])
    extends Element {
  }
  private class LineElement(s:String) extends ArrayElement(Array(s)) {
    override def width = s.length
    override def height = 1
  }
  private class UniformElement (ch :Char,
                                override val width:Int,
                                override val height:Int
                               ) extends Element{
    private val line=ch.toString * width
    def contents = Array.fill(height)(line)
  }
  def elem(contents: Array[String]):Element =
    new ArrayElement(contents)
  def elem(chr:Char, width:Int, height:Int) :Element =
    new UniformElement(chr,width,height)
  def elem(line:String) :Element =
    new LineElement(line)
}

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
  def above(that: Element) :Element =
    Element.elem(this.contents ++ that.contents)
  def beside(that: Element) :Element = {
    Element.elem(
      for(
        (line1,line2) <- this.contents zip that.contents
      ) yield line1+line2
    )
  }
  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = Element.elem(' ', (w - width) / 2, height)
      val right = Element.elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = Element.elem(' ', width, (h - height) / 2)
      val bot = Element.elem(' ', width, h - height - top.height)
      top above this above bot
    }
  override def toString = contents mkString "\n"
}
