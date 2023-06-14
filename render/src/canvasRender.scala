import util._
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import scalajs.js.timers.setTimeout
import org.scalajs.dom.window.alert
import org.scalajs.dom.html.{Input, Canvas}
import org.scalajs.dom.CanvasRenderingContext2D
import Letters._

object CanvasRender {
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
        length += ww + 235
        ww
      } else {
        alert("Word found with incorrect structure")
        throw(null)
      }
    }
    println(s"Set canvas width to $length")
    canvas.width = (length / 2.5).toInt + 200
    var cl = 0
    val c2d = canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]
    c2d.fillStyle = "white"
    c2d.fillRect(0, 0, canvas.width, canvas.height)
    c2d.translate(25, 0)
    c2d.scale(1/2.5d, 1/2.5d)
    var last = false
    for ((word, ww) <- text.zip(shapes)) {
      def renderIn(init: Seq[String], v: Seq[String], end: Seq[String]) = {
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
      }
      if (word.length == 3) {
        println(s"Render: $word")
        val Seq(init, v, end) = word
        renderIn(init, v, end)
      } else {
        val Seq(init, v, end, suffix) = word
        println(s"Render: $word")
        renderIn(init, v, end)
        c2d.translate(-200, 0)
        Suffix.find(c2d, suffix.mkString)
        c2d.translate(235, 0)
      }
    }
  }
}