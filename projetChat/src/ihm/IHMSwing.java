package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class IHMSwing {

	private JFrame frmChat;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMSwing window = new IHMSwing();
					window.frmChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IHMSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChat = new JFrame();
		frmChat.setTitle("Chat");
		frmChat.setBackground(new Color(153, 102, 255));
		frmChat.setBounds(100, 100, 670, 935);
		frmChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChat.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 856, 433, 50);
		frmChat.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel smilieBtn = new JLabel("");
		smilieBtn.setIcon(new ImageIcon("D:\\Adrar\\javaWorkspace2\\projetChat\\img\\submit.png"));
		smilieBtn.setBounds(495, 856, 46, 40);
		frmChat.getContentPane().add(smilieBtn);
		
		JLabel whizzBtn = new JLabel("");
		whizzBtn.setIcon(new ImageIcon("D:\\Adrar\\javaWorkspace2\\projetChat\\img\\submit.png"));
		whizzBtn.setBounds(552, 856, 46, 40);
		frmChat.getContentPane().add(whizzBtn);
		
		JLabel sendBtn = new JLabel("");
		sendBtn.setIcon(new ImageIcon("D:\\Adrar\\javaWorkspace2\\projetChat\\img\\submit.png"));
		sendBtn.setBounds(439, 856, 46, 40);
		frmChat.getContentPane().add(sendBtn);
		
		JLabel photoBtn = new JLabel("");
		photoBtn.setIcon(new ImageIcon("D:\\Adrar\\javaWorkspace2\\projetChat\\img\\submit.png"));
		photoBtn.setBounds(608, 856, 46, 40);
		frmChat.getContentPane().add(photoBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(334, 686, 277, 116);
		frmChat.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 11, 257, 94);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
