object Pyramide {

  var hauteur = 3
  var taille = hauteur * ((hauteur + 1) / 2)
  var permutations: List[Array[Int]] = Nil

  def indice(l: Int, c: Int): Int = {
    return (l * (l - 1)) / 2 + c - 1
  }

  def duplique(src: Array[Int]): Array[Int] = {
    var dist = Array.fill(src.length)(0)
    for (i <- src.indices) {
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
        for (i <- 0 until rang) {
          if (tab(i) == valeur)
            dejaPris = true
        }
        println("--------------")
        if (!dejaPris) {
          tab(rang) = valeur
          
            
            //println(tab(rang-1))
            //println(tab(rang))
            //println(tab(rang-2))
            //println(math.abs((tab(rang-1)-tab(rang))))
            if(correcte(tab,rang))
            { 
            	genere(rang + 1, tab)
            }
          
          
         }
      }
    }
  }

  def correcte(tab: Array[Int], rang:Int): Boolean = {
    var permutation = new String()
    for (i <- tab.indices)
      permutation += tab(i)
    for (ligne <- 1 until hauteur) {
      for (col <- 1 to ligne) {
        if(indice(ligne+1,col+1)<=rang){
        	val n1 = tab(indice(ligne + 1, col))
        	val n2 = tab(indice(ligne + 1, col + 1))
        	val n3 = tab(indice(ligne, col))

        	if (math.abs(n1 - n2) != n3)
        		return false
      }}
    }
    return true
  }

  def main(args: Array[String]): Unit = {
    println("Hello")
    
    var total:Int = 0
    
    genere(0, Array.fill(taille)(0))
    for(i<-permutations.indices)
    {
      println()
      total += 1
     for(j<-permutations(i).indices)
     {
       println(permutations(i)(j))
     }
    }
    println("TOTAL :"+total)
  }

}
