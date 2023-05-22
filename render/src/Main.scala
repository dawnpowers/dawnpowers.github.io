import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import org.scalajs.dom.window.alert
import org.scalajs.dom.html.{Input, Canvas}
import org.scalajs.dom.CanvasRenderingContext2D
import Letters._

object Main extends App {

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

  def renderOnCanvas(text: Seq[Seq[Seq[String]]], canvas: Canvas): Unit = {
    var length = 0
    val shapes = for (word <- text) yield {
      if (word.length == 3) {
        val Seq(init, v, end) = word
        val es = end.map(size).sum + 50 * (end.length - 1)
        val is = init.map(size).sum + 50 * (init.length - 1)
        val ww = (es max is)
        length += ww + 200
        ww
      } else if (word.length == 4) {
        println("Suffix")
        val Seq(init, v, end, suffix) = word
        val es = end.map(size).sum + 50 * (end.length - 1)
        val is = init.map(size).sum + 50 * (init.length - 1)
        val ww = (es max is)
        length += ww + 200
        ww
      } else {
        alert("Word found with incorrect structure")
        throw(null)
      }
    }
    println(s"Set canvas width to $length")
    canvas.width = length
    var cl = 0
    val c2d = canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]
    c2d.fillStyle = "white"
    c2d.fillRect(0, 0, canvas.width, canvas.height)
    c2d.translate(25, 0)

    var last = false
    for ((word, ww) <- text.zip(shapes)) {
      if (word.length == 3) {
        val Seq(init, v, end) = word
        c2d.lineWidth = 40
        c2d.strokeStyle = "black"
        val es = end.map(size).sum
        val is = init.map(size).sum
        val offset1 = ((es - is) max 0) / 2
        var i1 = offset1
        for (letter <- init) {
          println(s"Printing (init) $letter @ $i1 + $cl")
          c2d.save()
          c2d.translate(25 + cl + i1, 0)
          Letters.consonants.get(letter).map(_(c2d))
          c2d.restore()
          i1 += size(letter) + 50
        }
        // todo: Vowels
        //c2d.strokeRect(cl - 20, 525, ww + 220, 0)
        last = Letters.vowels.get(v.head).map(_(c2d, ww + 220, last)).getOrElse(false)
        val offset2 = ((is - es) max 0) / 2
        var i2 = offset2
        for (letter <- end) {
          println(s"Printing (end) $letter @ $i2 + $cl")
          c2d.save()
          c2d.translate(25 + cl + i2, 550)
          Letters.consonants.get(letter).map(_(c2d))
          c2d.restore()
          i2 += size(letter) + 50
        }
        c2d.translate(ww + 200, 0)
      } else {
        val Seq(init, v, end, suffix) = word
        val c2d = canvas.getContext("2d")
      }
    }
  }

  val input = document.getElementById("text-to-render").asInstanceOf[Input]
  input.onkeypress = (e) => {
    if (e.charCode == 13) renderTextContent()
  }
  val canvas = document.getElementById("render-canvas").asInstanceOf[Canvas]
  canvas.height = 1050
  @JSExportTopLevel("renderTextContent")
  def renderTextContent(): Unit = {
    println("You clicked!")
    println(s"Input content: ${input.value}")
    renderOnCanvas(input.value.split(" ").toSeq.map(parseWord), canvas)
  }
  renderTextContent()
}