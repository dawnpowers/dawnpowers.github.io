import CanvasRender._
import util._
import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import scalajs.js.timers.setTimeout
import org.scalajs.dom.window.alert
import org.scalajs.dom.html.{Input, Canvas}
import org.scalajs.dom.svg.SVG
import org.scalajs.dom.CanvasRenderingContext2D
import Letters._
import Util._
import SvgRender.renderOnSvg


object Main extends App {
  val input = document.getElementById("text-to-render").asInstanceOf[Input]
  input.onkeydown = (e) => {
    setTimeout(50)(renderTextContent())
  }
  val canvas = document.getElementById("render-canvas").asInstanceOf[Canvas]
  val svg = document.getElementById("render-svg").asInstanceOf[SVG]
  println(s"canvas: $canvas, svg: $svg")
  canvas.height = (1050 / 2.5).toInt
  @JSExportTopLevel("renderTextContent")
  def renderTextContent(): Unit = {
    println("You clicked!")
    println(s"Input content: ${input.value}")
    renderOnCanvas(input.value.split(" ").toSeq.map(parseWord), canvas)
    renderOnSvg(input.value.split(" ").toSeq.map(parseWord), svg)
  }
  renderTextContent()
}