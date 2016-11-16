import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.BoxLayout;
import java.awt.Color;

public class XMLBase extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					XMLBase frame = new XMLBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public XMLBase() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JButton btnImportFile = new JButton("Import File");
		contentPane.add(btnImportFile);
		
		ScrollPane scrollPane = new ScrollPane();
		contentPane.add(scrollPane);
		
		JTextArea textPane = new JTextArea();
		scrollPane.add(textPane);
		textPane.setEditable(false);
		
		FileChosenListener fileListner = new FileChosenListener(textPane);
		btnImportFile.addActionListener(fileListner);
		
		JButton btnNVerifyFile = new JButton("Verify and Display");
		contentPane.add(btnNVerifyFile);
		
		XMLVerifyListener xmlVer = new XMLVerifyListener(textPane);
		btnNVerifyFile.addActionListener(xmlVer);
	}

}
