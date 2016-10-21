
object Main {

  def duplique (src: Array[Boolean], dst: Array[Boolean]): Unit ={
    for (i<-0 to src.length)
      dst(i) = src(i)
  }
  
  def cherche(poid: Array[Int],capacite:Int)
  {
    var len = poids.length
    var meilleure:Array[Boolean] = Array.fill(len)(false)
    chercheRec(0,Array.fill(len)(false))
    println
    print("Meilleure solution trouvée")
    affiche(meilleure,len)
    print("Valeur du sac:"+valeurTotale(meilleur,poids))
    
    def chercheRec(profondeur:Int,sac_courant:Array[Boolean])
    {
      
    }
  }

}
