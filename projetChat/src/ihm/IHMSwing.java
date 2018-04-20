package ihm;

import java.awt.EventQueue;
import java.awt.Insets;

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
		smilieBtn.setIcon(new ImageIcon("C:\\Users\\Joris.Dadou\\git\\projetChat\\projetChat\\img\\smile.png"));
		smilieBtn.setBounds(495, 856, 46, 40);
		frmChat.getContentPane().add(smilieBtn);
		
		JLabel whizzBtn = new JLabel("");
		whizzBtn.setIcon(new ImageIcon("C:\\Users\\Joris.Dadou\\git\\projetChat\\projetChat\\img\\whizz.png"));
		whizzBtn.setBounds(552, 856, 46, 40);
		frmChat.getContentPane().add(whizzBtn);
		
		JLabel sendBtn = new JLabel("");
		
		sendBtn.setIcon(new ImageIcon("C:\\Users\\Joris.Dadou\\git\\projetChat\\projetChat\\img\\submit.png"));
		sendBtn.setBounds(439, 856, 46, 40);
		frmChat.getContentPane().add(sendBtn);
		
		JLabel photoBtn = new JLabel("");
		photoBtn.setIcon(new ImageIcon("C:\\Users\\Joris.Dadou\\git\\projetChat\\projetChat\\img\\photo.png"));
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
		
		JButton btnSendButton = new JButton("");
		btnSendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println(textField.getText());					
			}
		});
		 btnSendButton.setBounds(439, 856, 46, 40);
		 btnSendButton.setFocusPainted(false);
		 btnSendButton.setMargin(new Insets(0, 0, 0, 0));
		 btnSendButton.setContentAreaFilled(false);
		 btnSendButton.setBorderPainted(false);
		 btnSendButton. setOpaque(false);
		frmChat.getContentPane().add(btnSendButton);
		
		JButton btnSmileyButton = new JButton("");
		btnSmileyButton.setBounds(499, 856, 42, 41);
		 btnSmileyButton.setFocusPainted(false);
		 btnSmileyButton.setMargin(new Insets(0, 0, 0, 0));
		 btnSmileyButton.setContentAreaFilled(false);
		 btnSmileyButton.setBorderPainted(false);
		 btnSmileyButton. setOpaque(false);
		frmChat.getContentPane().add(btnSmileyButton);
		
		JButton btnWizzButton = new JButton("");
		btnWizzButton.setBounds(551, 856, 47, 40);
		 btnWizzButton.setFocusPainted(false);
		 btnWizzButton.setMargin(new Insets(0, 0, 0, 0));
		 btnWizzButton.setContentAreaFilled(false);
		 btnWizzButton.setBorderPainted(false);
		 btnWizzButton. setOpaque(false);
		frmChat.getContentPane().add(btnWizzButton);
		
		JButton btnPictureButton = new JButton("");
		btnPictureButton.setBounds(604, 856, 50, 40);
		btnPictureButton.setFocusPainted(false);
		 btnPictureButton.setMargin(new Insets(0, 0, 0, 0));
		 btnPictureButton.setContentAreaFilled(false);
		 btnPictureButton.setBorderPainted(false);
		 btnPictureButton. setOpaque(false);
		frmChat.getContentPane().add(btnPictureButton);
		
	}
}
