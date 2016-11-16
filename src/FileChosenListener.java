import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileChosenListener implements ActionListener{
	
	private JTextArea txt;
	private String fileText;

	public FileChosenListener(JTextArea txt){
		this.txt = txt;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fm = new JFileChooser();
		int open = fm.showOpenDialog(null);
		if(open == fm.APPROVE_OPTION){
			FileStorage.f = fm.getSelectedFile();	//fetches file
			parseFile();
		}
	}
	
	public void parseFile(){
		DocumentBuilderFactory docFact = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuild = docFact.newDocumentBuilder();
			Document doc = docBuild.parse(FileStorage.f);
			doc.getDocumentElement().normalize();	//Collapses text on multiple lines.
			
			Element root = doc.getDocumentElement();
			fileText += root.getTextContent();
			txt.setText(fileText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
