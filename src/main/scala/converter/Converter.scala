package converter

trait ConverterBase {
  import com.amazonaws.services.lambda.runtime.Context
  import io.Source

  // テスト時はオーバーライドできるように（ファイルからとかプロキシ使うときとか）
  def fromURL(url: String, encode: String = "UTF-8") = Source.fromURL(url, encode)

  def htmlToXml(url: String, context: Context) = {
    import java.io.StringReader
    import scala.collection.JavaConverters._
    import scala.xml.Node
    import scala.xml.parsing.NoBindingFactoryAdapter
    import nu.validator.htmlparser.sax.HtmlParser
    import nu.validator.htmlparser.common.XmlViolationPolicy
    import org.xml.sax.InputSource

    val hp = new HtmlParser
    hp.setNamePolicy(XmlViolationPolicy.ALLOW)
    val saxer = new NoBindingFactoryAdapter
    hp.setContentHandler(saxer)
    hp.parse(new InputSource(new StringReader(fromURL(url).getLines.mkString)))

    saxer.rootElem.toString

  }

  def xmlToJson(url: String, context: Context) = {
    import scala.xml.XML
    import net.liftweb.json.{Xml, pretty, render}
    val source = fromURL(url).getLines.mkString
    val xml = XML.loadString(source)
    pretty(render(Xml.toJson(xml)))
  }
}

class Converter extends ConverterBase
