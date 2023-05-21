sealed trait Place
sealed trait Labial extends Place
sealed trait Coronal extends Place
sealed trait Dorsal extends Place
sealed trait Laryngeal extends Place

sealed trait Bilabial extends Labial
sealed trait Labiodental extends Labial
sealed trait Linguolabial extends Labial with Coronal
sealed trait Dental extends Coronal
sealed trait Alveolar extends Coronal
sealed trait PostAlveolar extends Coronal
sealed trait Retroflex extends Coronal
sealed trait Palatal extends Coronal with Dorsal
sealed trait Velar extends Dorsal
sealed trait Uvular extends Dorsal
sealed trait Epiglottal extends Laryngeal
sealed trait Glottal extends Laryngeal

sealed trait Manner
sealed trait Sibilant extends Manner
sealed trait NonSibilant extends Manner
sealed trait Lateral extends Manner
sealed trait Nasal extends Manner
sealed trait Plosive extends Manner
sealed trait Affricate extends Manner
sealed trait SibilantAffricate extends Affricate with Sibilant
sealed trait NonSibilantAffricate extends Affricate with NonSibilant
sealed trait Fricative extends Manner
sealed trait SibilantFricative extends Fricative with Sibilant
sealed trait NonSibilantFricative extends Fricative with NonSibilant
sealed trait Approximant extends Manner
sealed trait Tap extends Manner
sealed trait Trill extends Manner
sealed trait LateralAffricate extends Affricate
sealed trait LateralFricative extends Fricative with Lateral
sealed trait LateralTap extends Lateral with Tap

sealed trait Voiced
sealed trait Unvoiced

sealed trait SemiVowel

sealed trait Vowel
sealed trait High extends Vowel
sealed trait Mid extends Vowel
sealed trait Low extends Vowel
sealed trait Tense extends Vowel
sealed trait Lax extends Vowel
sealed trait Front extends Vowel
sealed trait Middle extends Vowel
sealed trait Back extends Vowel

class Phoneme(val letter: String) {
  override def toString = letter
  val seqScore = this match {
    case _: Approximant => 2
    case _: Nasal => 4
    case _: NonSibilantFricative => 6
    case _: SibilantFricative => 6
    case _: Plosive => 8
    case _: Affricate => 7
    case _ => -1
  }
  def canComeAfterEnd(that: Phoneme): Boolean = {
    if (this.letter == that.letter) return false
    this match {
      case _: (Voiced & Unvoiced) =>
      case _: Voiced if !that.isInstanceOf[Voiced] => return false
      case _: Unvoiced if !that.isInstanceOf[Unvoiced] => return false
      case _ =>
    }
    if (that.isInstanceOf[NonSibilantFricative] && this.isInstanceOf[SibilantFricative]) return true
    if (that.isInstanceOf[Bilabial & Plosive] && this.isInstanceOf[Dental & Plosive]) return true
    return false
  }
  def canComeAfterBegin(that: Phoneme): Boolean = {
    if (this.letter == that.letter) return false
    this match {
      case _: (Voiced & Unvoiced) =>
      case _: Voiced if !that.isInstanceOf[Voiced] => return false
      case _: Unvoiced if !that.isInstanceOf[Unvoiced] => return false
      case _ =>
    }
    if (that.isInstanceOf[Bilabial]) {      // m p b
      if (that.seqScore < this.seqScore) return false // Must decrease
      if (this.isInstanceOf[Approximant]) return true // w j ɹ
      if (this.isInstanceOf[SibilantFricative] && this.isInstanceOf[Alveolar | PostAlveolar]) return true // s z ʃ
    }
    if (that.isInstanceOf[Labiodental]) {   // f v
      if (that.seqScore < this.seqScore) return false // Must decrease
      if (this.isInstanceOf[Approximant]) return true // w j ɹ
      if (this.isInstanceOf[SibilantFricative] && this.isInstanceOf[Alveolar]) return true // s z
      if (this.seqScore == that.seqScore) return false
      if (this.isInstanceOf[SibilantFricative] && this.isInstanceOf[PostAlveolar]) return true // ʃ
    }
    if (that.isInstanceOf[Dental]) {        // n t d s z ɹ θ ð
      if (that.seqScore < this.seqScore) return false // Must decrease
      if (that.seqScore > 6 && this.isInstanceOf[Approximant]) return true // w j ɹ
      if (this.seqScore == that.seqScore) return false
    }
    if (that.isInstanceOf[Alveolar]) {      // n t d s z ɹ
      if (that.seqScore < this.seqScore) return false // Must decrease
      if (that.isInstanceOf[SibilantFricative] && this.isInstanceOf[Dental]) return true
      if (this.seqScore == that.seqScore) return false
      if (that.seqScore >= 6 && this.isInstanceOf[Alveolar]) return true
    }
    if (that.isInstanceOf[PostAlveolar]) {  // n t d ʧ ʤ ɹ ʃ
      if (that.seqScore < this.seqScore) return false // Must decrease
      if (that.seqScore == 8 && this.isInstanceOf[Labiodental]) return true
    }
    if (that.isInstanceOf[Retroflex]) {     // ʈ ɖ ꭧ ꭦ ʂ
      if (this.isInstanceOf[Approximant]) return true
      if (this.seqScore == that.seqScore) return false
      if (that.seqScore != 7 && this.isInstanceOf[Retroflex] && this.seqScore != 7 && this.seqScore != 6) return true
    }
    if (that.seqScore < this.seqScore) return false // Must decrease
    if (that.isInstanceOf[Palatal]) {       // j ɕ tɕ

    }
    if (that.isInstanceOf[Velar]) {         // x k g
      if (this.isInstanceOf[Palatal | Approximant] && !that.isInstanceOf[Approximant]) return true
    }
    if (that.isInstanceOf[Glottal]) {       // h

    }
    //val c10 = this.isInstanceOf[NonSibilant] && that.isInstanceOf[Sibilant] && this.seqScore == that.seqScore
    //val c9 = c3 || c4 || c5 || c6 || c7 || c8 || c10
    //c1 && c2 && c9 && this != that
    return false
  }
}

object Letters {
  val m = new Phoneme("m") with Bilabial with Nasal with Voiced 
  val ŋ = new Phoneme("ŋ") with Velar with Nasal with Voiced
  val p = new Phoneme("p") with Bilabial with Plosive with Unvoiced
  val b = new Phoneme("b") with Bilabial with Plosive with Voiced
  val n = new Phoneme("n") with Dental with Alveolar with PostAlveolar with Nasal with Voiced
  val t = new Phoneme("t") with Dental with Alveolar with PostAlveolar with Plosive with Unvoiced
  val d = new Phoneme("d") with Dental with Alveolar with PostAlveolar with Plosive with Voiced
  val t1 = new Phoneme("ʈ") with Retroflex with Plosive with Unvoiced
  val d1 = new Phoneme("ɖ") with Retroflex with Plosive with Voiced
  val k = new Phoneme("k") with Velar with Plosive with Unvoiced
  val g = new Phoneme("g") with Velar with Plosive with Voiced
  val j1 = new Phoneme("ʧ") with PostAlveolar with SibilantAffricate with Unvoiced
  val j2 = new Phoneme("ʤ") with PostAlveolar with SibilantAffricate with Voiced
  val c1 = new Phoneme("ꭧ") with Retroflex with SibilantAffricate with Unvoiced
  val c2 = new Phoneme("ꭦ") with Retroflex with SibilantAffricate with Voiced
  val k1 = new Phoneme("ʨ") with Palatal with SibilantAffricate with Unvoiced
  val g1 = new Phoneme("ʥ") with Palatal with SibilantAffricate with Voiced
  val f = new Phoneme("f") with Labiodental with NonSibilantFricative with Unvoiced
  val v = new Phoneme("v") with Labiodental with NonSibilantFricative with Voiced
  val þ = new Phoneme("θ") with Dental with NonSibilantFricative with Unvoiced
  val ð = new Phoneme("ð") with Dental with NonSibilantFricative with Voiced
  val s = new Phoneme("s") with Dental with Alveolar with SibilantFricative with Unvoiced
  val z = new Phoneme("z") with Dental with Alveolar with SibilantFricative with Voiced
  val š = new Phoneme("ʃ") with Palatal with PostAlveolar with Fricative with Unvoiced
  val š1 = new Phoneme("ʂ") with Retroflex with SibilantFricative with Unvoiced
  val x1 = new Phoneme("ɕ") with Palatal with SibilantFricative with Unvoiced
  val x = new Phoneme("x") with Velar with NonSibilantFricative with Unvoiced
  val h = new Phoneme("h") with Glottal with NonSibilantFricative with Unvoiced
  val w = new Phoneme("w") with Labial with Velar with Approximant with Voiced with Unvoiced
  val y = new Phoneme("j") with Palatal with Approximant with Voiced with Unvoiced with SemiVowel
  val r = new Phoneme("ɹ") with Dental with Alveolar with PostAlveolar with Approximant with Voiced with Unvoiced with SemiVowel

  val consonants = Seq(m, n, ŋ, p, b, t, d, t1, d1, k, g, j1, j2, c1, c2, k1, g1, f, v, þ, ð, s, z, š, š1, x, x1, h, w, y, r)

  val i = new Phoneme("ɪ") with High with Lax with Front
  val u = new Phoneme("ʊ") with High with Lax with Back
  val ii = new Phoneme("iː") with High with Tense with Front
  val ia = new Phoneme("ɪə̯ː") with High with Lax with Front
  val uu = new Phoneme("uː") with High with Tense with Back
  val ua = new Phoneme("ʊə̯ː") with High with Lax with Back

  val ei = new Phoneme("eɪ̯") with Mid with Lax with Front
  val o = new Phoneme("oʊ̯") with Mid with Lax with Back
  val ea = new Phoneme("ɛː") with Mid with Tense with Front
  val eu = new Phoneme("ɛə̯ː") with Mid with Lax with Front
  val oo = new Phoneme("ɔː") with Mid with Tense with Back
  val oa = new Phoneme("ɔə̯ː") with Mid with Lax with Back

  val æ = new Phoneme("æ") with Low with Tense with Front
  val ai = new Phoneme("æɪ̯") with Low with Lax with Front
  val a = new Phoneme("ɑ") with Low with Tense with Back
  val au = new Phoneme("ɑʊ̯") with Low with Lax with Back

  val vowels = Seq(i, u, ii, ia, uu, ua, ei, o, ea, eu, oo, oa, æ, ai, a, au)
}

