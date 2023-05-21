
  implicit class StringSeqOps(s: Array[String]) {
    def *(oth: Array[String]): Array[String] = {
      s.map(sc => oth.map(oc => sc ++ oc)).flatten
    }.distinct
  }

  val A = "j w".split(" ")
  val B = "ɹ".split(" ")
  val C = "m n ŋ".split(" ") // nʲ mʲ
  val D = "z ɕ ʂ ð v".split(" ")
  val E = "f s θ ʃ".split(" ") // sʲ fʲ
  val F = "b d g".split(" ")
  val G = "p t k".split(" ")

  val H = "f s v θ ð z ʃ ʂ".split(" ")
  val I = "ɹ w".split(" ")
  val J = "p b t d k g".split(" ")
  val K = "ʤ ꭧ ꭦ ʨ".split(" ")
  val L = "m n ŋ".split(" ") // nʲ mʲ

  //val M = "tʲ pʲ dʲ bʲ".split(" ")
  //val N = M ++ "wʲ zʲ mʲ sʲ fʲ nʲ vʲ".split(" ")

  val X = H ++ I ++ J ++ K ++ L ++ H*I ++ H*J ++ H*L ++ K*I ++ J*I ++ H*J*I// ++ H*N ++ N
  
  val Y = A ++ B ++ C ++ D ++ E ++ F ++ G ++ A*B ++ A*C ++ A*D ++ A*E ++ A*F ++ A*G ++ B*C ++ B*D ++ B*E ++ B*F ++ B*G ++ C*D ++ C*E ++ C*F ++ C*G ++ D*F ++ E*G ++ F*D ++ G*G ++ G*E ++ Array("pt", "kt") ++ A*C*E ++ A*C*F ++ A*D*F ++ A*C*G ++ A*E*G ++ B*C*E ++ B*C*F ++ B*C*G ++ B*E*Array("s") ++ B*E*G ++ B*Array("k")*E*Array("s") ++ B*Array("k")*E*Array("t") ++ B*D*G ++ B*Array("g")*D*Array("z") ++ B*Array("g")*D*Array("d") ++ C*D*F ++ C*E*G
  val V = "ɪ iː uː ɪə̯ː ʊ eɪ̯ ɛː ʊə̯ː oʊ̯ ɛə̯ː ɔə̯ː ɑ ɔː æ æɪ̯ ɑʊ̯".split(" ")
  
  val W = X*V*Y

  //println(W.mkString(" "))
  val pick = for (i <- 0 until 250) yield W(util.Random.nextInt(W.size))
  println(pick.mkString(" "))