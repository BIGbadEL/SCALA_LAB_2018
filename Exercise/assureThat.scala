package Exercise

object assure {
  def	enableAssurance	=	true
  def	assureThat(	v:	Boolean	)	{
    if ( enableAssurance && !v ) {
      throw new java.lang.RuntimeException("Failed assuring that condition is true")
    }
  }
  def main(args: Array[String]) {
    assureThat(	1<	2	)//	ok
    assureThat( 1 < -1 ) // bad
  }
}
