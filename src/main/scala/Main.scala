

object Main {

  def duplique(src: Array[Boolean], dst: Array[Boolean]): Unit = {
    for (i <- 0 to src.length)
      dst(i) = src(i)
  }
  
  def cherche(poids: Array[Int],capacite:Int)
  {
    var len = poids.length
    var meilleure:Array[Boolean] = Array.fill(len)(false)
    chercheRec(0,Array.fill(len)(false))
    println
    print("Meilleure solution trouvée")
    affiche(meilleure,len)
    print("Valeur du sac:"+valeurTotale(meilleure,poids))
    
    def chercheRec(profondeur:Int,sac_courant:Array[Boolean])
    {
      
    }
  }

  def valeurTotale(objets: Array[Boolean], poids: Array[Int]): Int = {
    var total = 0
    for (i <- objets.indices) {
      if (objets(i))
        total += poids(i)
    }
    return total
  }

  def affiche(objets: Array[Boolean], indiceMax: Int): Unit = {
    for (i <- 0 to math.min(indiceMax, objets.length - 1)) {
      if (objets(i))
        print("O")
      else
        print("N")
    }

    if (indiceMax < objets.length - 1) {
      for (i <- indiceMax until objets.length)
        print("...")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Bite")
  }

}
