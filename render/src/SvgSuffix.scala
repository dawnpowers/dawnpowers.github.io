import org.scalajs.dom.CanvasRenderingContext2D
import LettersSvg.StrokeWidth

object SvgSuffix {
  def find(s: String): String = {
    println(s"s: $s")
    // Definiteness
    val offset = s match {
      case "an" | "un" | "ir" | "apt" | "uapt" | "ip" =>
        -1
      case "ask'" | "oaþs" | "uask'" | "iaþs" | "aukt" | "oaks" | "uakt" | "iaks" =>
        0
      case "aus" | "op" | "oos" | "uus" | "iis" | "aupz" | "ook" | "uupz" | "iik" =>
        1
      case _ => 0
    }
    // Plurality
    val str1 = s match {
      // Sg
      case "an" | "ask'" | "aus" | "oaþs" | "oos" | "un" | "uask'" | "uus" | "ir" | "iaþs" | "iis" =>
        val init = offset * 75
        val path = s"M${100 + init} 50 L${100 + init} 1000"
        s"""<path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      // Pl
      case "apt" | "aukt" | "aupz" | "op" | "oaks" | "ook" | "uapt" | "uakt" | "uupz" | "ip" | "iaks" | "iik" | "aid" =>
        val init = offset * 40
        val path1 = s"M${65 + init} 50 L${65 + init} 1000"
        val path2 = s"M${135 + init} 50 L${135 + init} 1000"
        (s"""<path d="$path1" stroke="black" fill="none" stroke-width="$StrokeWidth"/>""" +
         s"""<path d="$path2" stroke="black" fill="none" stroke-width="$StrokeWidth"/>""")
      case _ =>
        ""
    }
    println(s"St1: $str1")

    // Tense
    val str2 = s match {
      case "an" | "ask'" | "aus" | "apt" | "aukt" | "aupz" =>
        val path = "M5 1000 L195 1000"
        s"""<path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      case "ir" | "iaþs" | "iis" | "ip" | "iaks" | "iik" =>
        val path = "M5 50 L195 50"
        s"""<path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      case "un" | "uask" | "uus" | "uapt" | "uakt" | "uupz" =>
        val path1 = "M5 1000 L195 1000"
        val path2 = "M5 50 L195 50"
        s"""<path d="$path1" stroke="black" fill="none" stroke-width="$StrokeWidth"/>""" +
        s"""<path d="$path2" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      case "oos" =>
        val path = "M15 440 L100 525"
        s"""<path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      case "ook" =>
        val path = "M15 435 L105 525"
        s"""<path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      case "op" =>
        val path = "M15 615 L105 525"
        s"""<path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      case _ =>
        ""
    }   
    println(s"St2: $str2")


    // Gender
    val str3: String = s match {
      case "upt" =>
        val path = "M25 50 L25 175 L175 175 L175 325 L25 325 L25 1000"
        s"""<path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      case "uč" =>
        val path = "M25 50 L25 700 L175 700 L175 875 L25 875 L25 1000"
        s"""<path d="$path" stroke="black" fill="none" stroke-width="$StrokeWidth"/>"""
      case _ =>
        ""
    }
    println(s"St3: $str3")
    str1 + str2 + str3
  }
}