import java.awt.Color;
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
	private String fileText;
	
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
			doc.getDocumentElement().normalize();	//Collapses text on multiple lines.
			Element root = doc.getDocumentElement();
			fileText = root.getTextContent();
			txt.setForeground(Color.BLACK);
			txt.setText(fileText);
			System.out.println("Everything is a-okay :)");
		}
		catch(Exception e){
			txt.setForeground(Color.RED);
			txt.setText("Something went really wrong\n" +
						e.getMessage() +
						" \nPlease try importing a well-formatted XML file");
		}
	}
}
