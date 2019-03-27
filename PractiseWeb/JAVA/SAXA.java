import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
public class SAXA{
	public static void main(String[] args){
		try{
			File inp = new File("data.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			UserHandler uh = new UserHandler();
			parser.parse(inp,uh);
		}
		catch(Exception e){e.printStackTrace();}
		
	}
}
