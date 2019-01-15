package ex

/**
  * @author: kexi
  * @date: 2019/1/11
  */
class Rational(n: Int, d: Int) extends Ordered[Rational]{
  require(d!=0)
  private val g =gcd (n.abs,d.abs)
  val numer =n/g
  val denom =d/g
  override def toString = numer + "/" +denom
  def +(that:Rational)  =
    new Rational(
      numer * that.denom + that.numer* denom,
      denom * that.denom
    )
  def * (that:Rational) =
    new Rational( numer * that.numer, denom * that.denom)
  def + (i:Int) =
    new Rational (numer + i * denom, denom)
  def this(n:Int) = this(n,1)
  private def gcd(a:Int,b:Int):Int =
    if(b==0) a else gcd(b, a % b)
  implicit def intToRational(x:Int) = new Rational(x)
  override def compare (that:Rational)= (this.numer*that.denom)-(that.numer*that.denom)
}
