package ihm;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;

import dao.MessageBean;
import dao.UserBean;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class IHMSwing {

	private JFrame frmChat;
	private JTextArea writeMessage;
	private JTextArea chatArea;
	private JButton btnSendButton;

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
	 
	//Gestion des Refresh de chaque fenetre du Chat 
	
	  public void updateChat(ArrayList<MessageBean> liste) {
		  for (int i = 0; i < liste.size(); i++) {
			  MessageBean message = liste.get(i);
			  System.out.println(message);
	        }
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
		
		JLabel smilieBtn = new JLabel("");
		smilieBtn.setIcon(new ImageIcon("C:\\Users\\Joris.Dadou\\git\\projetChat\\projetChat\\img\\smile.png"));
		smilieBtn.setBounds(496, 846, 46, 40);
		frmChat.getContentPane().add(smilieBtn);
		
		JLabel whizzBtn = new JLabel("");
		whizzBtn.setIcon(new ImageIcon("C:\\Users\\Joris.Dadou\\git\\projetChat\\projetChat\\img\\whizz.png"));
		whizzBtn.setBounds(552, 845, 46, 40);
		frmChat.getContentPane().add(whizzBtn);
		
		JLabel sendBtn = new JLabel("");
		
		sendBtn.setIcon(new ImageIcon("C:\\Users\\Joris.Dadou\\git\\projetChat\\projetChat\\img\\submit.png"));
		sendBtn.setBounds(439, 845, 46, 40);
		frmChat.getContentPane().add(sendBtn);
		
		JLabel photoBtn = new JLabel("");
		photoBtn.setIcon(new ImageIcon("C:\\Users\\Joris.Dadou\\git\\projetChat\\projetChat\\img\\photo.png"));
		photoBtn.setBounds(608, 845, 46, 40);
		frmChat.getContentPane().add(photoBtn);
		
		btnSendButton = new JButton("");
		btnSendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					System.out.println(writeMessage.getText());
					chatArea.setText(chatArea.getText() + writeMessage.getText()+"\n");
					 writeMessage.setText("Tapez votre message...");
					 
			}
		});
		 btnSendButton.setBounds(439, 845, 46, 40);
		 btnSendButton.setFocusPainted(false);
		 btnSendButton.setMargin(new Insets(0, 0, 0, 0));
		 btnSendButton.setContentAreaFilled(false);
		 btnSendButton.setBorderPainted(false);
		 btnSendButton. setOpaque(false);
		frmChat.getContentPane().add(btnSendButton);
		
		JButton btnSmilieButton = new JButton("");
		btnSmilieButton.setBounds(496, 845, 42, 41);
		 btnSmilieButton.setFocusPainted(false);
		 btnSmilieButton.setMargin(new Insets(0, 0, 0, 0));
		 btnSmilieButton.setContentAreaFilled(false);
		 btnSmilieButton.setBorderPainted(false);
		 btnSmilieButton. setOpaque(false);
		frmChat.getContentPane().add(btnSmilieButton);
		
		JButton btnWhizzButton = new JButton("");
		btnWhizzButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnWhizzButton.setBounds(552, 845, 47, 40);
		 btnWhizzButton.setFocusPainted(false);
		 btnWhizzButton.setMargin(new Insets(0, 0, 0, 0));
		 btnWhizzButton.setContentAreaFilled(false);
		 btnWhizzButton.setBorderPainted(false);
		 btnWhizzButton. setOpaque(false);
		frmChat.getContentPane().add(btnWhizzButton);
		
		JButton btnPhotoButton = new JButton("");
		btnPhotoButton.setBounds(604, 846, 50, 40);
		btnPhotoButton.setFocusPainted(false);
		 btnPhotoButton.setMargin(new Insets(0, 0, 0, 0));
		 btnPhotoButton.setContentAreaFilled(false);
		 btnPhotoButton.setBorderPainted(false);
		 btnPhotoButton. setOpaque(false);
		frmChat.getContentPane().add(btnPhotoButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 846, 406, 40);
		frmChat.getContentPane().add(scrollPane);
		
		writeMessage = new JTextArea();
		scrollPane.setViewportView(writeMessage);
		writeMessage.setBackground(Color.YELLOW);
		writeMessage.setLineWrap(true);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 12, 634, 823);
		frmChat.getContentPane().add(scrollPane_1);
		
		chatArea = new JTextArea();
		chatArea.setLineWrap(true);
		chatArea.setEditable(false);
		scrollPane_1.setViewportView(chatArea);
		
	
		
	}
}
