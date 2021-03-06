import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLVerifyListener implements ActionListener{
	
	private JTextArea txt;
	private String fileText;
	private final static Logger logger = Logger.getLogger(XMLVerifyListener.class.getName());

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
			logger.setLevel(Level.INFO);
			logger.addHandler(new ConsoleHandler());
			
			DocumentBuilder docBuild = docFact.newDocumentBuilder();
			docBuild.setErrorHandler(new ParseErrorHandler());

			Document doc = docBuild.parse(FileStorage.f);
			doc.getDocumentElement().normalize();	//Collapses text on multiple lines.		
			
			DOMSource dSource = new DOMSource(doc);	//DOM tree
			StringWriter writer = new StringWriter();	
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();	//changes DOM into results
			transformer.transform(dSource, result);
			txt.setText(writer.toString());

			

			txt.setForeground(Color.BLACK);


			System.out.println("Everything is a-okay :)");
		}
		catch(Exception e){
			txt.setForeground(Color.RED);
			txt.setText("Something went really wrong\n" +
						e.getMessage() +
						" \nPlease try importing a well-formatted XML file");
			logger.log(Level.SEVERE, e.toString());
		}
	}
}
