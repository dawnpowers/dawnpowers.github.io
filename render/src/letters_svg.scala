
object LettersSvg {
  final val StrokeWidth = 40
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
  val map = Map (
    "t" -> s"""<path d="M0 100 L300 250 L0 400" stroke="black" fill="none" stroke-width="$StrokeWidth"/>""",
    "d" -> s"""<rect x="0" y="100" width="300" height="300" stroke="black" fill="none" stroke-width="$StrokeWidth"/>""",
    "k" -> s"""<g transform="translate(200, 200) rotate(135)">
    <path d="M0 -150 L100 0 L0 150 L-100 0 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    <path d="M100 0 L150 -75 L200 0 L150 75 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    <path d="M-100 0 L-150 -87.5 L-200 0 L-150 87.5 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  </g>""",
  "g" -> s"""<path d="M0 100 L0 400 L200 400 L200 120 L400 120" stroke="black" fill="none" stroke-width="$StrokeWidth"/>""",
  "č" -> s"""
    <path d="M0 400 L300 400 L300 100" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    <path d="M100 100 L100 400" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "j" -> s"""
  <path d="M0 400 L225 175" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <path d="M125 100 L300 275" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "š" -> s"""
  <path d="M0 300 L150 230 L250 230 L400 300 L200 400 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <path d="M150 230 L200 100 L250 230" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "j'" -> s"""
  <path d="M0 400 L225 175 M125 100 L300 275" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <circle cx="105" cy="187.5" r="20" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "t'" -> s"""
  <path d="M0 100 L300 250 L0 400" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <circle cx="70" cy="250" r="20" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "d'" -> s"""
  <rect x="0" y="100" width="300" height="300" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <circle cx="150" cy="250" r="20" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "k'" -> s"""
    <g transform="translate(200, 200) rotate(135)">
      <path d="M0 -150 L100 0 L0 150 L-100 0 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M100 0 L150 -75 L200 0 L150 75 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M-100 0 L-150 -87.5 L-200 0 L-150 87.5 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
    <circle cx="200" cy="200" r="20" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "g'" -> s"""
  <path d="M0 100 L0 400 L200 400 L200 120 L400 120" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <circle cx="100" cy="250" r="20" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "č'" -> s"""
  <path d="M0 400 L300 400 L300 100" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <path d="M100 100 L100 400" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <circle cx="200" cy="250" r="20" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "š'" -> s"""
  <path d="M0 300 L150 230 L250 230 L400 300 L200 400 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <path d="M150 230 L200 100 L250 230" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  <circle cx="200" cy="300" r="20" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "þ" -> s"""<path d="M300 225 L250 100 L50 150 L0 250 L50 350 L250 400 L300 275" stroke="black" fill="none" stroke-width="$StrokeWidth"/>""",
  "ð" -> s"""<path d="M100 150 L200 250 L100 350 L0 250 Z M200 150 L300 250 L200 350 L100 250 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>""",
  "s" -> s"""
  <path d="M0 275 L75 100 L150 400 L225 115 L300 385 L400 125" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  """,
  "z" -> s"""
  <g transform="translate(0, -25)">
    <path d="M150 150 L250 250 L150 350 L50 250 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    <path d="M0 100 L150 250 L150 450" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
  </g>
  """,
  "w" -> s"""
    <g>
      <rect x="0" y="175" width="300" height="150" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M0 50 L0 450" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M300 50 L300 450" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "n" -> s"""
    <g>
      <rect x="0" y="100" width="200" height="200" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M200 300 L200 400 L400 400 L400 300" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "ŋ" -> s"""
    <g>
      <rect x="0" y="100" width="150" height="150" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M0 100 L400 100 L400 400 L-20 400" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "m" -> s"""
    <g>
      <rect x="125" y="225" width="150" height="150" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M0 100 L125 225 L275 225 L400 100" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "b" -> s"""
    <g>
      <path d="M0 400 L100 150 L400 100 L300 350 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M100 150 L300 350" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "p" -> s"""
    <g>
      <path d="M0 150 L150 350 L300 250 L150 150 L0 350" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "f" -> s"""
    <g>
      <path d="M300 100 L0 100 L0 400 L300 400" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M150 400 L150 200" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "v" -> s"""
    <g>
      <path d="M0 415 L150 100 L300 250 L10 425 Z" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M350 50 L230 170" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "h" -> s"""
    <g>
      <path d="M0 100 L400 400" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
      <path d="M0 275 L400 275" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "r" -> s"""
    <g>
      <path d="M0 100 L150 400 L200 350 L250 400 L350 200" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "x" -> s"""
    <g>
      <path d="M0 50 L0 450 L225 450 L100 350 L250 250 L100 150" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,

  "y" -> s"""
    <g>
      <path d="M10 100 L10 250 L210 325 L0 400" stroke="black" fill="none" stroke-width="$StrokeWidth"/>
    </g>
  """,
  )

  val vowels: Map[String, (Int, Boolean) => (String, Boolean)] = Map(
    "i" -> ((len, last) => {
      ((if (last) "M-20 525 L75 525 " else "") + "M0 450 L0 600", false)
    }),
    "ia" -> ((len, last) => {
      val path = if (last) "M-20 525 L75 525 " else ""
      (path + s"M0 450 L0 600 M0 525 L$len 525", true)
    }),
    "ei" -> ((len, last) => {
      val path = if (last) "M-20 525 L75 525 " else ""
      (path + s"M0 600 L75 525", false)
    }),
    "eu" -> ((len, last) => {
      val path = if (last) "M-20 525 L75 525 " else ""
      (path + s"M0 600 L75 525 L$len 525", true)
    }),
    "u" -> ((len, last) => {
      val path = if (last) "M-20 525 L75 525 " else ""
      (path + "M0 450 L75 525", false)
    }),
    "ua" -> ((len, last) => {
      val path = if (last) "M-20 525 L75 525 " else ""
      (path + s"M0 450 L75 525 L$len 525", true)
    }),
    "o" -> ((len, last) => {
      val path = "M0 450 L0 600 L150 525 Z"
      (path, false)
    }),
    "oa" -> ((len, last) => {
      val path = "M0 450 L0 600 L150 525 Z M150 525 L" + len + " 525"
      (path, true)
    }),
    "a" -> ((len, last) => {
      val path = if (last) "M-20 525 L125 525 " else ""
      val path1 = "M0 600 L100 450 "
      val path2 = "M75 600 L175 450"
      (path + path1 + path2, false)
    }),
    "æ" -> ((len, last) => {
      val path = if (last) "M-20 525 L75 525 " else ""
      val path1 = "M0 600 L0 525 "
      val path2 = "L75 525 L75 450"
      (path + path1 + path2, false)
    }),
    "ai" -> ((len, last) => {
      val path = if (last) "M-20 525 L75 525 " else ""
      val path1 = "M0 450 L75 525 "
      val path2 = "L0 600"
      (path + path1 + path2, false)
    }),

    "au" -> ((len, last) => {
      val path = if (last) "M-20 525 L20 525 " else ""
      val path1 = "M0 475 L0 575 "
      val path2 = "L100 575 L100 475"
      (path + path1 + path2, false)
    }),

    "uu" -> ((len, last) => {
      val path = if (last) "M-20 525 L25 525 " else ""
      val path1 = "M0 600 L50 450 "
      val path2 = "L100 525 L" + len + " 525"
      (path + path1 + path2, true)
    }),

    "ii" -> ((len, last) => {
      val path = if (last) "M-20 525 L25 525 " else ""
      val path1 = "M0 450 L50 600 "
      val path2 = "L100 525 L" + len + " 525"
      (path + path1 + path2, true)
    }),

    "oo" -> ((len, last) => {
      val path = if (last) "M-20 525 L100 525 " else ""
      val path1 = "M0 575 L50 575 "
      val path2 = "L100 525 L" + len + " 525"
      (path + path1 + path2, true)
    }),

    "ea" -> ((len, last) => {
      val path = if (last) "M-20 525 L100 525 " else ""
      val path1 = "M0 475 L50 475 "
      val path2 = "L100 525 L" + len + " 525"
      (path + path1 + path2, true)
    })
  )
}