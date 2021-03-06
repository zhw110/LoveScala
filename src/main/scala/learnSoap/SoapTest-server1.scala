package learnSoap.t1

//http://wiki.summercode.com/a_trivial_soap_client_in_scala
//This is test the server: http://www.webservicex.net/globalweather.asmx?op=GetCitiesByCountry

import scala.xml.{Elem,XML}
class SoapClient {
  private def error(msg: String) = {
    println("SoapClient error: " + msg)
  }
  
  def wrap(xml: Elem) : String = {
    val buf = new StringBuilder
    buf.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n")
    buf.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n")
    buf.append("<soap:Body>\n")
    buf.append(xml.toString)
    buf.append("</soap:Body>\n")
    buf.append("</soap:Envelope>\n")
    buf.toString
  }
  
  def sendMessage(host: String, req: Elem) : Option[Elem] = {
    val url = new java.net.URL(host)
    val outs = wrap(req).getBytes
    val conn = url.openConnection.asInstanceOf[java.net.HttpURLConnection]
    try {
      conn.setRequestMethod("POST")
      conn.setDoOutput(true)
      conn.setRequestProperty("Content-Length", outs.length.toString)
      conn.setRequestProperty("Content-Type", "text/xml")
      conn.getOutputStream.write(outs)
      conn.getOutputStream.close
      Some(XML.load(conn.getInputStream))
    }
    catch {
      case e: Exception => error("post: " + e)
        error("post:" + scala.io.Source.fromInputStream(conn.getErrorStream).mkString)
        None
    }
  }
}

object SoapTest {
  def doTest1 {
    val host = "http://www.webservicex.net/globalweather.asmx"
    val req: Elem = <GetCitiesByCountry xmlns="http://www.webserviceX.NET">
      <CountryName>China</CountryName>
    </GetCitiesByCountry>
    
    val cli = new SoapClient
    println("##### request:\n" + cli.wrap(req))
    val resp = cli.sendMessage(host, req)
    if (resp.isDefined) {
      println("##### response:\n" + resp.get.toString)
    }
  }
  

  
  def main(args: Array[String]) {
    doTest1
  }
}