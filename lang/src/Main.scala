import Letters.vowels
import Letters.consonants

object Main extends App {
  def generateInitial(last: Phoneme): Seq[String] = {
    val s1 = for (c <- Letters.consonants if c.canComeAfterBegin(last); gi <- generateInitial(c)) yield {
      last.letter + gi
    }
    last.letter +: s1
  }
  def generateWords(): Seq[String] = {
    val letters = for (c1 <- Letters.consonants) yield {
      generateInitial(c1)
    }
    letters.flatten
  }
  def generateEnd(last: Phoneme): Seq[String] = {
    val s1 = for (c <- Letters.consonants if c.canComeAfterEnd(last); gi <- generateEnd(c)) yield {
      last.letter + gi
    }
    last.letter +: s1
  }
  def generateWords2(): Seq[String] = {
    val letters = for (c1 <- Letters.consonants) yield {
      generateEnd(c1)
    }
    letters.flatten
  }

  val init = generateWords()
  println(init.mkString("X = ", " ", ""))
  println(vowels.mkString("V = ", " ", ""))
  println(generateWords2().mkString("Y = ", " ", ""))

  //val pick = for (i <- 0 until 250) yield words(util.Random.nextInt(words.size))
  //println(pick.mkString(" "))
}