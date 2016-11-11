object Sac_A_Dos {

  def duplique(src: Array[Boolean], dst: Array[Boolean]): Unit = {
    for (i <- src.indices)
      dst(i) = src(i)
  }

  def cherche(poids: Array[Int], capacite: Int) {
    val len = poids.length
    val meilleure: Array[Boolean] = Array.fill(len)(false)
    chercheRec(0, Array.fill(len)(false))
    println
    print("Meilleure solution trouvée : ")
    affiche(meilleure, len)
    print(", Valeur du sac : " + valeurTotale(meilleure, poids))

    def chercheRec(profondeur: Int, courante: Array[Boolean]) {

      val valeur = valeurTotale(courante, poids)

      print(" (prof = " + profondeur + ") Explore ")
      affiche(courante, profondeur)
      print(" Valeur " + valeur)

      if (valeur > capacite) {
        println(" *** Oups, ca deborde (backtrack!) ***")
        return
      }

      if (valeurTotale(courante, poids) > valeurTotale(meilleure, poids)) {
        duplique(courante, meilleure)
        print(" Nouvelle meilleure solution ")
      }
      else
        print("   ")

      if (profondeur == poids.length) {
        println("(Cas terminal)")
        return
      }
      else
        println("(Cas general")

      mettreDansSac(courante, profondeur)
      chercheRec(profondeur + 1, courante)

      retirerDuSac(courante, profondeur)
      chercheRec(profondeur + 1, courante)
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

  def mettreDansSac(objets: Array[Boolean], obj: Int): Unit = {
    if (objets(obj))
      println("L’objet " + obj + " est déjà pris.")
    objets(obj) = true
  }

  def retirerDuSac(objets: Array[Boolean], obj: Int): Unit = {
    if (!objets(obj))
      println("L’objet " + obj + " est déjà posé.")
    objets(obj) = false
  }

  def main(args: Array[String]): Unit = {
    val t = Array(1, 2, 3, 4, 5, 8, 9, 10, 11, 12)
    cherche(t, 4)
  }

}
