import mill._, scalalib._, scalajslib._

object lang extends ScalaModule {
  def scalaVersion = "3.2.2"
}
object render extends ScalaJSModule {
  def scalaVersion = "3.2.2"
  def scalaJSVersion = "1.13.1"
  def ivyDeps = Agg(ivy"org.scala-js:scalajs-dom_sjs1_3:2.2.0")
}