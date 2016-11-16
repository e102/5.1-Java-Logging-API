import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextArea;

public class XMLVerifyListener implements ActionListener{
	
	private File f;
	private JTextArea txt;
	
	public XMLVerifyListener(File f, JTextArea txt){
		this.f = f;
		this.txt = txt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
	public void parseFile(){
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
