package IO;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {
	
	static String filepath = System.getProperty("user.dir") + "\\Cookies.xml";


	public static void main(String[] args) {
		String value = ReadXMLFile.getData("student", "lastname");
		System.out.println(value);
		
	}
	
	public static String getData(String tagName, String key){
		String value = null;
		String value2 = null;
		try {

			File fXmlFile = new File(filepath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
					
			NodeList nList = doc.getElementsByTagName(tagName);
			
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					value2 = eElement.getAttribute("rollno");
					value =  eElement.getElementsByTagName(key).item(0).getTextContent();
					
					System.out.println(eElement.getElementsByTagName(key).item(0).getTextContent());
					

				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		return value2;
		  }
	
}
