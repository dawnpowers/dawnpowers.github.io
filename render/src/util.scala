import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import scalajs.js.timers.setTimeout
import org.scalajs.dom.window.alert
import org.scalajs.dom.html.{Input, Canvas}
import org.scalajs.dom.CanvasRenderingContext2D
import Letters._

object Util {
  type Letter = Seq[String]
  def parseSyllable(syllable: String): Letter = {
    if (syllable.isEmpty) Seq()
    else if (consonants2 contains syllable.take(2)) {
      syllable.take(2) +: parseSyllable(syllable.drop(2))
    } else syllable.take(1) +: parseSyllable(syllable.drop(1))
  }
  def parseWord(word: String): Seq[Letter] = {
    val (initial, rest1) = word.span(c => !(Seq('a', 'e', 'i', 'o', 'u', 'æ') contains c))
    val (vowel, rest2) = rest1.span(Seq('a', 'e', 'i', 'o', 'u', 'æ') contains _)
    if (rest2.exists(Seq('a', 'e', 'i', 'o', 'u', 'æ') contains _)) {
      val (post, rest3) = rest2.span(c => !(Seq('a', 'e', 'i', 'o', 'u', 'æ') contains c))
      Seq(parseSyllable(initial), Seq(vowel), parseSyllable(post), Seq(rest3))
    } else {
      Seq(parseSyllable(initial), Seq(vowel), parseSyllable(rest2))
    }
  }

}