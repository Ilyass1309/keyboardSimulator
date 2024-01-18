package fr.irit.elipse.keyboardsimulator.launcher;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlReader {
	
	public static NodeList readXml(String filePath) {
		try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(filePath);
	    document.getDocumentElement().normalize();
	    return document.getElementsByTagName("entry");
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
