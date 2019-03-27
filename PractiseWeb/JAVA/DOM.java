import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class DOM{
	public static void main(String[] args) throws Exception{
		File inputFile = new File("data.xml");
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuild = dbfactory.newDocumentBuilder();
		Document doc = docBuild.parse(inputFile);
		doc.getDocumentElement().normalize();
		System.out.println(doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("student");
		for(int i = 0;i<nList.getLength();i++){
			Node nNode = nList.item(i);
			System.out.println(nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				Element e = (Element) nNode;
				System.out.println(e.getElementsByTagName("firstname").item(0).getTextContent());
			}
		}
	}
}