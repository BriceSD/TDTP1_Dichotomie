
object Main {

  def duplique (src: Array[Boolean], dst: Array[Boolean]): Unit ={
    for (i<-0 to src.length)
      dst(i) = src(i)
  }

}
