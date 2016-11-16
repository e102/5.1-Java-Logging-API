import java.awt.Color;
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
			txt.setForeground(Color.BLACK);
			txt.setText("File fetched. Location = " + FileStorage.f.getAbsolutePath() +
					" \n Press Verify and Display to proceed");
		}
	}
}
