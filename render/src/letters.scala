import org.scalajs.dom.CanvasRenderingContext2D

object Letters {
  val consonants1 = Seq("m", "n", "ŋ", "p", "b", "t", "d", "k", "g", "č", "j", "f", "v", "þ", "ð", "s", "z", "š", "x", "h", "r", "w", "y")
  val consonants2 = Seq("t'", "d'", "č'", "j'", "k'", "g'", "š'")
  def size(s: String): Int = {
    if (s.isEmpty) 0
    else {
      (s.head match {
        case 't' => 300
        case 'd' => 300
        case 'k' => 400
        case 'g' => 400
        case 'č' => 300
        case 'j' => 300
        case 'š' => 400
        case 'þ' => 300
        case 'ð' => 300
        case 's' => 400
        case 'z' => 250
        case 'w' => 300
        case 'n' => 400
        case 'ŋ' => 400
        case 'm' => 400
        case 'b' => 400
        case 'p' => 300
        case 'f' => 300
        case 'v' => 375
        case 'h' => 400
        case 'y' => 210
        case 'r' => 350
        case 'x' => 250
        case _ => -50
      }) + 50 + size(s.tail)
    }
  }
  val consonants = Map[String, CanvasRenderingContext2D => Unit](
    "t" -> ((c2d) => {
      c2d.moveTo(0, 100)
      c2d.lineTo(300, 250)
      c2d.lineTo(0, 400)
      c2d.stroke()
    }),
    "d" -> ((c2d) => {
      c2d.strokeRect(0, 100, 300, 300)
    }),
    "k" -> ((c2d) => {
      c2d.save()
      c2d.translate(200, 250)
      c2d.rotate(3 * math.Pi / 4)
      c2d.moveTo(0, -150)
      c2d.lineTo(100, 0)
      c2d.lineTo(0, 150)
      c2d.lineTo(-100, 0)
      c2d.closePath()
      c2d.stroke()
      c2d.moveTo(100, 0)
      c2d.lineTo(150, -75)
      c2d.lineTo(200, 0)
      c2d.lineTo(150, 75)
      c2d.closePath()
      c2d.stroke()
      c2d.stroke()
      c2d.moveTo(-100, 0)
      c2d.lineTo(-150, -87.5)
      c2d.lineTo(-200, 0)
      c2d.lineTo(-150, 87.5)
      c2d.closePath()
      c2d.stroke()
      c2d.restore()
    }),
    "g" -> ((c2d) => {
      c2d.moveTo(0, 100)
      c2d.lineTo(0, 400)
      c2d.lineTo(200, 400)
      c2d.lineTo(200, 120)
      c2d.lineTo(400, 120)
      c2d.stroke()
    }),
    "č" -> ((c2d) => {
      c2d.moveTo(0, 400)
      c2d.lineTo(300, 400)
      c2d.lineTo(300, 100)
      c2d.stroke()
      c2d.moveTo(100, 100)
      c2d.lineTo(100, 400)
      c2d.stroke()
    }),
    "j" -> ((c2d) => {
      c2d.moveTo(0, 400)
      c2d.lineTo(225, 175)
      c2d.stroke()
      c2d.moveTo(125, 100)
      c2d.lineTo(300, 275)
      c2d.stroke()
    }),
    "š" -> ((c2d) => {
      c2d.moveTo(0, 300)
      c2d.lineTo(150, 230)
      c2d.lineTo(250, 230)
      c2d.lineTo(400, 300)
      c2d.lineTo(200, 400)
      c2d.closePath()
      c2d.stroke()
      c2d.moveTo(150, 230)
      c2d.lineTo(200, 100)
      c2d.lineTo(250, 230)
      c2d.stroke()
    }),
    "t'" -> ((c2d) => {
      c2d.moveTo(0, 100)
      c2d.lineTo(300, 250)
      c2d.lineTo(0, 400)
      c2d.stroke()
      c2d.moveTo(70, 250)
      c2d.arc(50, 250, 20, 0, 2*math.Pi)
      c2d.stroke()
    }),
    "d'" -> ((c2d) => {
      c2d.strokeRect(0, 100, 300, 300)
      c2d.moveTo(170, 250)
      c2d.arc(150, 250, 20, 0, 2*math.Pi)
      c2d.stroke()
    }),
    "k'" -> ((c2d) => {
      c2d.save()
      c2d.translate(200, 250)
      c2d.rotate(3 * math.Pi / 4)
      c2d.moveTo(0, -150)
      c2d.lineTo(100, 0)
      c2d.lineTo(0, 150)
      c2d.lineTo(-100, 0)
      c2d.closePath()
      c2d.stroke()
      c2d.moveTo(100, 0)
      c2d.lineTo(150, -75)
      c2d.lineTo(200, 0)
      c2d.lineTo(150, 75)
      c2d.closePath()
      c2d.stroke()
      c2d.stroke()
      c2d.moveTo(-100, 0)
      c2d.lineTo(-150, -87.5)
      c2d.lineTo(-200, 0)
      c2d.lineTo(-150, 87.5)
      c2d.closePath()
      c2d.stroke()
      c2d.restore()
      c2d.moveTo(170, 250)
      c2d.arc(200, 250, 20, 0, 2*math.Pi)
      c2d.stroke()
    }),
    "g'" -> ((c2d) => {
      c2d.moveTo(0, 100)
      c2d.lineTo(0, 400)
      c2d.lineTo(200, 400)
      c2d.lineTo(200, 120)
      c2d.lineTo(400, 120)
      c2d.stroke()
      c2d.moveTo(120, 250)
      c2d.arc(100, 250, 20, 0, 2*math.Pi)
      c2d.stroke()
    }),
    "č'" -> ((c2d) => {
      c2d.moveTo(0, 400)
      c2d.lineTo(300, 400)
      c2d.lineTo(300, 100)
      c2d.stroke()
      c2d.moveTo(100, 100)
      c2d.lineTo(100, 400)
      c2d.stroke()
      c2d.moveTo(220, 250)
      c2d.arc(200, 250, 20, 0, 2*math.Pi)
      c2d.stroke()
    }),
    "j'" -> ((c2d) => {
      c2d.moveTo(0, 400)
      c2d.lineTo(225, 175)
      c2d.stroke()
      c2d.moveTo(125, 100)
      c2d.lineTo(300, 275)
      c2d.stroke()
      c2d.moveTo(125, 187.5)
      c2d.arc(105, 187.5, 20, 0, 2*math.Pi)
      c2d.stroke()
    }),
    "š'" -> ((c2d) => {
      c2d.moveTo(0, 300)
      c2d.lineTo(150, 230)
      c2d.lineTo(250, 230)
      c2d.lineTo(400, 300)
      c2d.lineTo(200, 400)
      c2d.closePath()
      c2d.stroke()
      c2d.moveTo(150, 230)
      c2d.lineTo(200, 100)
      c2d.lineTo(250, 230)
      c2d.stroke()
      c2d.moveTo(220, 300)
      c2d.arc(200, 300, 20, 0, 2*math.Pi)
      c2d.stroke()
    }),
    "þ" -> ((c2d) => {
      c2d.moveTo(300, 225)
      c2d.lineTo(250, 100)
      c2d.lineTo(50, 150)
      c2d.lineTo(0, 250)
      c2d.lineTo(50, 350)
      c2d.lineTo(250, 400)
      c2d.lineTo(300, 275)
      c2d.stroke()
    }),
    "ð" -> ((c2d) => {
      c2d.beginPath()
      c2d.moveTo(100, 150)
      c2d.lineTo(200, 250)
      c2d.lineTo(100, 350)
      c2d.lineTo(0, 250)
      c2d.closePath()
      c2d.stroke()
      c2d.beginPath()
      c2d.moveTo(200, 150)
      c2d.lineTo(300, 250)
      c2d.lineTo(200, 350)
      c2d.lineTo(100, 250)
      c2d.closePath()
      c2d.stroke()
    }),
    "s" -> ((c2d) => {
      c2d.moveTo(0, 275)
      c2d.lineTo(75, 100)
      c2d.lineTo(150, 400)
      c2d.lineTo(225, 115)
      c2d.lineTo(300, 385)
      c2d.lineTo(400, 125)
      c2d.stroke()
    }),
    "z" -> ((c2d) => {
      c2d.translate(0, -25)
      c2d.beginPath()
      c2d.moveTo(150, 150)
      c2d.lineTo(250, 250)
      c2d.lineTo(150, 350)
      c2d.lineTo(50, 250)
      c2d.closePath()
      c2d.stroke()
      c2d.moveTo(0, 100)
      c2d.lineTo(150, 250)
      c2d.lineTo(150, 450)
      c2d.stroke()
      c2d.translate(0, 25)
    }),
    "w" -> ((c2d) => {
      c2d.strokeRect(0, 175, 300, 150)
      c2d.moveTo(0, 50)
      c2d.lineTo(0, 450)
      c2d.stroke()
      c2d.moveTo(300, 50)
      c2d.lineTo(300, 450)
      c2d.stroke()
    }),
    "n" -> ((c2d) => {
      c2d.strokeRect(0, 100, 200, 200)
      c2d.moveTo(200, 300)
      c2d.lineTo(200, 400)
      c2d.lineTo(400, 400)
      c2d.lineTo(400, 300)
      c2d.stroke()
    }),
    "ŋ" -> ((c2d) => {
      c2d.strokeRect(0, 100, 150, 150)
      c2d.moveTo(0, 100)
      c2d.lineTo(400, 100)
      c2d.lineTo(400, 400)
      c2d.lineTo(-20, 400)
      c2d.stroke()
    }),
    "m" -> ((c2d) => {
      c2d.strokeRect(125, 225, 150, 150)
      c2d.moveTo(0, 100)
      c2d.lineTo(125, 225)
      c2d.lineTo(275, 225)
      c2d.lineTo(400, 100)
      c2d.stroke()
    }),
    "b" -> ((c2d) => {
      c2d.moveTo(0, 400)
      c2d.lineTo(100, 150)
      c2d.lineTo(400, 100)
      c2d.lineTo(300, 350)
      c2d.closePath()
      c2d.stroke()
      c2d.moveTo(100, 150)
      c2d.lineTo(300, 350)
      c2d.stroke()
    }),
    "p" -> ((c2d) => {
      c2d.moveTo(0, 150)
      c2d.lineTo(150, 350)
      c2d.lineTo(300, 250)
      c2d.lineTo(150, 150)
      c2d.lineTo(0, 350)
      c2d.stroke()
    }),
    "f" -> ((c2d) => {
      c2d.moveTo(300, 100)
      c2d.lineTo(0, 100)
      c2d.lineTo(0, 400)
      c2d.lineTo(300, 400)
      c2d.stroke()
      c2d.moveTo(150, 400)
      c2d.lineTo(150, 200)
      c2d.stroke()
    }),
    "v" -> ((c2d) => {
      c2d.moveTo(0, 415)
      c2d.lineTo(150, 100)
      c2d.lineTo(300, 250)
      c2d.lineTo(10, 425)
      c2d.closePath()
      c2d.stroke()
      c2d.moveTo(350, 50)
      c2d.lineTo(230, 170)
      c2d.stroke()
    }),
    "h" -> ((c2d) => {
      c2d.moveTo(0, 100)
      c2d.lineTo(400, 400)
      c2d.stroke()
      c2d.moveTo(0, 275)
      c2d.lineTo(400, 275)
      c2d.stroke()
    }),
    "r" -> ((c2d) => {
      c2d.moveTo(0, 100)
      c2d.lineTo(150, 400)
      c2d.lineTo(200, 350)
      c2d.lineTo(250, 400)
      c2d.lineTo(350, 200)
      c2d.stroke()
    }),
    "x" -> ((c2d) => {
      c2d.moveTo(0, 50)
      c2d.lineTo(0, 450)
      c2d.lineTo(225, 450)
      c2d.lineTo(100, 350)
      c2d.lineTo(250, 250)
      c2d.lineTo(100, 150)
      c2d.stroke()
    }),
    "y" -> ((c2d) => {
      c2d.moveTo(10, 100)
      c2d.lineTo(10, 250)
      c2d.lineTo(210, 325)
      c2d.lineTo(0, 400)
      c2d.stroke()
    }),
  )

  val vowels: Map[String, (CanvasRenderingContext2D, Int, Boolean) => Boolean] = Map(
    "i" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(75, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 450)
      c2d.lineTo(0, 600)
      c2d.stroke()
      false
    }),
    "ia" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(75, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 450)
      c2d.lineTo(0, 600)
      c2d.stroke()
      c2d.moveTo(0, 525)
      c2d.lineTo(len, 525)
      c2d.stroke()
      true
    }),
    "ei" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(75, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 600)
      c2d.lineTo(75, 525)
      c2d.stroke()
      false
    }),
    "eu" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(75, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 600)
      c2d.lineTo(75, 525)
      c2d.lineTo(len, 525)
      c2d.stroke()
      true
    }),
    "u" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(75, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 450)
      c2d.lineTo(75, 525)
      c2d.stroke()
      false
    }),
    "ua" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(75, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 450)
      c2d.lineTo(75, 525)
      c2d.lineTo(len, 525)
      c2d.stroke()
      true
    }),
    "o" -> ((c2d, len, last) => {
      c2d.moveTo(0, 450)
      c2d.lineTo(0, 600)
      c2d.lineTo(150, 525)
      c2d.closePath()
      c2d.stroke()
      false
    }),
    "oa" -> ((c2d, len, last) => {
      c2d.moveTo(0, 450)
      c2d.lineTo(0, 600)
      c2d.lineTo(150, 525)
      c2d.closePath()
      c2d.stroke()
      c2d.moveTo(150, 525)
      c2d.lineTo(len, 525)
      c2d.stroke()
      true
    }),
    "a" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(125, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 600)
      c2d.lineTo(100, 450)
      c2d.stroke()
      c2d.moveTo(75, 600)
      c2d.lineTo(175, 450)
      c2d.stroke()
      false
    }),
    "æ" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(75, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 600)
      c2d.lineTo(0, 525)
      c2d.lineTo(75, 525)
      c2d.lineTo(75, 450)
      c2d.stroke()
      false
    }),
    "ai" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(75, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 450)
      c2d.lineTo(75, 525)
      c2d.lineTo(0, 600)
      c2d.stroke()
      false
    }),
    "au" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(20, 525)
        c2d.stroke()
      }
      c2d.strokeRect(0, 475, 100, 100)
      false
    }),
    "uu" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(25, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 600)
      c2d.lineTo(50, 450)
      c2d.lineTo(100, 525)
      c2d.lineTo(len, 525)
      c2d.stroke()
      true
    }),
    "ii" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(25, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 450)
      c2d.lineTo(50, 600)
      c2d.lineTo(100, 525)
      c2d.lineTo(len, 525)
      c2d.stroke()
      true
    }),
    "oo" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(100, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 575)
      c2d.lineTo(50, 575)
      c2d.lineTo(100, 525)
      c2d.lineTo(len, 525)
      c2d.stroke()
      true
    }),
    "ea" -> ((c2d, len, last) => {
      if (last) {
        c2d.moveTo(-20, 525)
        c2d.lineTo(100, 525)
        c2d.stroke()
      }
      c2d.moveTo(0, 475)
      c2d.lineTo(50, 475)
      c2d.lineTo(100, 525)
      c2d.lineTo(len, 525)
      c2d.stroke()
      true
    }),
    
  )
}