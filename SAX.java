import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class SAX{
	public static void main(String[]args){
		try{
		File inputFile = new File("data.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		UserHandler handler = new UserHandler();
		parser.parse(inputFile,handler);
		}
		catch(Exception e){e.printStackTrace();}
}}
class UserHandler extends DefaultHandler{
	boolean bfirst = false;
	boolean blast = false;
	boolean bmark = false;
	@Override
	public void startElement(String uri,String localName,String qName,Attributes attributes)throws SAXException{
		if(qName.equalsIgnoreCase("student")){
			String rollNo = attributes.getValue("rollno");
			System.out.println(rollNo);
		}
		else if(qName.equalsIgnoreCase("firstname")){bfirst = true;}
		else if(qName.equalsIgnoreCase("lastname")){blast = true;}
		else if(qName.equalsIgnoreCase("marks")){bmark = true;}
	}
	@Override
	public void endElement(String uri,String localName,String qName)throws SAXException
	{
		if(qName.equalsIgnoreCase("student")){System.out.println(qName);}
	}
	@Override
	public void characters(char ch[],int start,int length)throws SAXException{
		if(bfirst == true){System.out.println("FIRSTNAME"+new String(ch,start,length));bfirst = false;}
		if(blast == true){System.out.println("LANME"+new String(ch,start,length));blast = false;}
		if(bmark == true){System.out.println("MARK"+new String(ch,start,length));bmark = false;}
	}}
		
