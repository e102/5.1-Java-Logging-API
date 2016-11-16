import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLVerifyListener implements ActionListener{
	
	private JTextArea txt;
	
	public XMLVerifyListener(JTextArea txt){
		this.txt = txt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		parseFile();
	}
	
	public void parseFile(){
		DocumentBuilderFactory docFact = DocumentBuilderFactory.newInstance();
		docFact.setNamespaceAware(true);
		docFact.setValidating(false);
		try{
			DocumentBuilder docBuild = docFact.newDocumentBuilder();
			docBuild.setErrorHandler(new ParseErrorHandler());
			Document doc = docBuild.parse(FileStorage.f);
			System.out.println("Everything is a-okay :)");
		}
		catch(Exception e){
			System.out.println("Something went really wrong");
			System.out.println(e.getMessage());
		}
//		NodeList nlist = doc.getElementsByTagName("*");
//		for (int i = 0; i < nlist.getLength(); i++) {
//			Node node = nlist.item(i);
//			if(node.getNodeType()== node.ELEMENT_NODE){
//				fileText += " ";
//				fileText += node.getNodeName();
//				System.out.println(fileText);
//			}
//		}
	}
}
