import org.scalajs.dom.document
import org.scalajs.dom.window
import org.scalajs.dom.window.alert
import org.scalajs.dom.svg.{SVG, Rect, Text, TextContent}
import LettersSvg._

object SvgRender {
  def renderOnSvg(text: Seq[Seq[Seq[String]]], svg: SVG): Unit = {
    var length = 100
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
    val mw = svg.parentNode.asInstanceOf[SVG].clientWidth
    val scale = (mw.toDouble / length) max 1
    svg.style.width = s"${scale * mw}px"
    println(s"Scale: $scale * $mw ($length)")
    var it = s"""<svg viewBox="0 0 $length 1000" transform="scale($scale, $scale)">"""
    var width = 50
    var last = false
    for ((word, ww) <- text.zip(shapes)) {
      def renderIn(init: Seq[String], v: Seq[String], end: Seq[String]) = {
        val es = end.map(size).sum
        val is = init.map(size).sum
        val offset1 = ((es - is) max 0) / 2
        var i1 = offset1
        for (letter <- init) {
          println(s"Printing (init) $letter @ $i1 + $width")
          val l = map.getOrElse(letter, "")
          it += s"""
          <g transform="translate(${i1 + width} 0)">
            $l
          </g>
          """
          i1 += size(letter) + 50
        }
        val (path, ln) = vowels.get(v.head).map(fn => fn(ww + 220, last)).getOrElse(("", false))
        last = ln
        it += s"""<g transform="translate($width 0)" ><path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/></g>"""""
        val offset2 = ((is - es) max 0) / 2
        var i2 = offset2
        for (letter <- end) {
          println(s"Printing (end) $letter @ $i2 + $width")
          val l = map.getOrElse(letter, "")
          it += s"""
          <g transform="translate(${i2 + width} 550)">
            $l
          </g>
          """
          i2 += size(letter) + 50
        }
        width += ww + 200
      }
      if (word.length == 3) {
        println(s"Render: $word")
        val Seq(init, v, end) = word
        renderIn(init, v, end)
      } else {
        val Seq(init, v, end, suffix) = word
        println(s"Render: $word")
        renderIn(init, v, end)
        //c2d.translate(-200, 0)
        val str = SvgSuffix.find(suffix.mkString)
        println(s"Suffix: $str")
        it += s"""<g transform="translate(${width-200} 0)">$str</g>"""
        //c2d.translate(235, 0)
        width += 35
      }
    }
    it += "</svg>"
    svg.innerHTML = it
  }
}
