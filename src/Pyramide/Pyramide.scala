object Main {
	
  var hauteur = 3
  var taille = hauteur/((hauteur+1)/2)
  var permutations:List[Array[Int]]=Nil
  
 def duplique(src: Array[Int]):Array[Int]={
  var dist = Array.fill(src.length)(0)
  for(i<-0 to src.length-1)
  {
    dist(i) = src(i)
  }
  return dist
}
  
  
}

