import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
class UserHandler extends DefaultHandler{
	boolean bmark = true;
	public void startElement(String uri,String localName,String qName,Attributes attributes){
		if(qName.equalsIgnoreCase("student")){
			String rollNo = attributes.getValue("rollno");
			System.out.println(rollNo);
		}
		else if(qName.equalsIgnoreCase("marks")){bmark = true;}
	}
	public void endElement(String uri,String localName,String qName){
	if(qName.equalsIgnoreCase("student")){System.out.println(qName);}
	}
	public void characters(char ch[],int start,int length){
		if(bmark == true){System.out.println(bmark+new String(ch,start,length));bmark = false;}
	}
}