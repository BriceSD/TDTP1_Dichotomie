object Main {

  var hauteur = 3
  var taille = hauteur * ((hauteur + 1) / 2)
  var permutations: List[Array[Int]] = Nil

  def indice(l: Int, c: Int): Int = {
    return (l * (l - 1)) / 2 + c - 1
  }

  def duplique(src: Array[Int]): Array[Int] = {
    var dist = Array.fill(src.length)(0)
    for (i <- 0 to src.length - 1) {
      dist(i) = src(i)
    }
    return dist
  }


  def genere(rang: Int, tab: Array[Int]): Unit = {
    if (rang >= tab.length)
    	permutations = duplique(tab) :: permutations
    else {
      for (valeur <- 1 to tab.length) {
        
        
        
        var dejaPris = false
        for (i <- 0 to rang - 1) {
          if (tab(i) == valeur)
            dejaPris = true
        }
        println("--------------")
        print(dejaPris)
        if (!dejaPris) {
          tab(rang) = valeur
          if(rang>=2)
          {
            
            println(tab(rang-1))
            println(tab(rang))
            println(tab(rang-2))
            println(math.abs((tab(rang-1)-tab(rang))))
            if(math.abs((tab(rang-1)-tab(rang)))==tab(rang-2))
            { 
              println("ici")
            	genere(rang + 1, tab)
            }
          }
          else
          {
            genere(rang + 1, tab)
          }
         }
      }
    }
  }

  def correcte(tab: Array[Int]): Boolean = {
    var permutation = new String()
    for (i <- 0 to tab.length - 1)
      permutation += tab(i)
    for (ligne <- 1 to hauteur - 1) {
      for (col <- 1 to ligne) {
        val n1 = tab(indice(ligne + 1, col))
        val n2 = tab(indice(ligne + 1, col + 1))
        val n3 = tab(indice(ligne, col))

        if (math.abs(n1 - n2) != n3)
          return false
      }
    }
    return true
  }

  def main(args: Array[String]): Unit = {
    println("Hello")
    
    var total:Int = 0
    
    genere(0, Array.fill(taille)(0))
    for(i<-0 until permutations.length)
    {
      println()
      total += 1
     for(j<-0 until permutations(i).length)
     {
       println(permutations(i)(j))
     }
    }
    println("TOTAL :"+total)
  }

}
