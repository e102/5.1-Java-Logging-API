import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
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

public class XMLSaveListener implements ActionListener {
	
	private JTextArea txt;
	private String fileText;
	private final static Logger logger = Logger.getLogger(XMLVerifyListener.class.getName());

	public XMLSaveListener(JTextArea txt){
		this.txt = txt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		saveFile();
	}
	
	public void saveFile(){
		DocumentBuilderFactory docFact = DocumentBuilderFactory.newInstance();
		docFact.setNamespaceAware(true);
		docFact.setValidating(false);
		try{
			logger.setLevel(Level.INFO);
			logger.addHandler(new ConsoleHandler());
			
			DocumentBuilder docBuild = docFact.newDocumentBuilder();
			docBuild.setErrorHandler(new ParseErrorHandler());

			Document doc = docBuild.parse(FileStorage.f);
			
			// At this point, if the XML was flawed the exception code would have executed
			fileText = txt.getText();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(FileStorage.f));
			writer.write(fileText);
			writer.close();
			
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
