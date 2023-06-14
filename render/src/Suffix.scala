import org.scalajs.dom.CanvasRenderingContext2D

object Suffix {
  def find(c2d: CanvasRenderingContext2D, s: String): Unit = {
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
    s match {
      // Sg
      case "an" | "ask'" | "aus" | "oaþs" | "oos" | "un" | "uask'" | "uus" | "ir" | "iaþs" | "iis" =>
        val init = offset * 75
        c2d.moveTo(100 + init, 50)
        c2d.lineTo(100 + init, 1000)
        c2d.stroke()
      // Pl
      case "apt" | "aukt" | "aupz" | "op" | "oaks" | "ook" | "uapt" | "uakt" | "uupz" | "ip" | "iaks" | "iik" | "aid" =>
        val init = offset * 40
        c2d.moveTo(65 + init, 50)
        c2d.lineTo(65 + init, 1000)
        c2d.stroke()
        c2d.moveTo(135 + init, 50)
        c2d.lineTo(135 + init, 1000)
        c2d.stroke()
      case _ =>
    }
    // Tense
    s match {
      case "an" | "ask'" | "aus" | "apt" | "aukt" | "aupz" =>
        c2d.moveTo(5, 1000)
        c2d.lineTo(195, 1000)
        c2d.stroke()
      case "ir" | "iaþs" | "iis" | "ip" | "iaks" | "iik" =>
        c2d.moveTo(5, 50)
        c2d.lineTo(195, 50)
        c2d.stroke()
      case "un" | "uask" | "uus" | "uapt" | "uakt" | "uupz" =>
        c2d.moveTo(5, 1000)
        c2d.lineTo(195, 1000)
        c2d.stroke()
        c2d.moveTo(5, 50)
        c2d.lineTo(195, 50)
        c2d.stroke()
      case "oos" =>
        c2d.moveTo(15, 440)
        c2d.lineTo(100, 525)
        c2d.stroke()
      case "ook" =>
        c2d.moveTo(15, 435)
        c2d.lineTo(105, 525)
        c2d.stroke()
      case "op" =>
        c2d.moveTo(15, 615)
        c2d.lineTo(105, 525)
        c2d.stroke()
      case _ => 
    }
    // Gender
    s match {
      case "upt" =>
        c2d.moveTo(25, 50)
        c2d.lineTo(25, 175)
        c2d.lineTo(175, 175)
        c2d.lineTo(175, 325)
        c2d.lineTo(25, 325)
        c2d.lineTo(25, 1000)
        c2d.stroke()
      case "uč" =>
        c2d.moveTo(25, 50)
        c2d.lineTo(25, 700)
        c2d.lineTo(175, 700)
        c2d.lineTo(175, 875)
        c2d.lineTo(25, 875)
        c2d.lineTo(25, 1000)
        c2d.stroke()
    
      case _ =>
    }    
  }
}