

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
    	if(profondeur==sac_courant.length-1){
    	  affiche(poids,profondeur);

    	}
    	else{
    	  if(poids(profondeur)+valeurTotale(sac_courant,poids)<=capacite)
    	  {
    	    sac_courant(profondeur) = true;
    	    chercheRec(profondeur+1,sac_courant);
    	  }
    	}
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

  def mettreDansSac(objets: Array[Boolean], obj:Int): Unit ={
    if(objets(obj))
      println("L’objet " + obj + " est déjà pris.")
    objets(obj) = true
  }

  def retirerDuSac(objets: Array[Boolean], obj:Int): Unit ={
    if(!objets(obj))
      println("L’objet " + obj + " est déjà posé.")
    objets(obj) = false
  }

  def main(args: Array[String]): Unit = {
    println("zakjnzaedkjlzaklj")
  }

}
