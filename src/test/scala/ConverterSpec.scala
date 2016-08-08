import org.scalatest._
import converter._

class ConverterSpec extends FlatSpec with Matchers with ConverterBase{
  import io.Source

  override def fromURL(url: String, encode: String = "UTF-8") = Source.fromFile(url, encode)

  "Converter.htmlToXml" should "ok" in {
    val url = "src/test/scala/test.html"
    val ret = htmlToXml(url, null)
    println(ret)
    ret != null
  }

  "Converter.xmlToJson" should "ok" in {
    val url = "src/test/scala/test.xml"
    val ret = xmlToJson(url, null)
    println(ret)
    ret != null
  }

}
