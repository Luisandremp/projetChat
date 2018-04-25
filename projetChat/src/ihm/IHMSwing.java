package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;

import ControlerPackage.Controler;
import dao.MessageBean;

public class IHMSwing {

	private JFrame frmChat;
	private JTextArea writeMessage;
	private JTextArea chatArea;
	private JButton btnSendButton;
	private JLabel errorLabel;
	private Controler controler;
	private JTextField loginTxtfield;
	public final static int INTERVAL = 1000;
	private Timer timer;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					IHMSwing window = new IHMSwing();
					window.frmChat.setVisible(true);

					Controler controler = new Controler();
					controler.setIhm(window);
					window.setControler(controler);

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
		StringBuilder s = new StringBuilder("");

		for (int i = 0; i < liste.size(); i++) {
			MessageBean message = liste.get(i);

			s.append(message.getAuthor().getName()+":  "+message.getContent()  + "\n");
		}
		System.out.println(s.toString());
		chatArea.setText(s.toString());
	}

	public void setControler(Controler controler){
		this.controler = controler;
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

		JPanel loginContainer = new JPanel();
		loginContainer.setBackground(new Color(230, 230, 250));
		loginContainer.setBounds(0, 0, 654, 897);
		frmChat.getContentPane().add(loginContainer);
		loginContainer.setLayout(null);

		JPanel loginBox = new JPanel();
		loginBox.setBackground(new Color(102, 205, 170));
		loginBox.setBounds(82, 382, 470, 201);
		loginContainer.add(loginBox);
		loginBox.setLayout(null);

		JLabel userNameLbl = new JLabel("User Name:");
		userNameLbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		userNameLbl.setBounds(65, 21, 117, 37);
		loginBox.add(userNameLbl);

		loginTxtfield = new JTextField();
		loginTxtfield.setBounds(65, 69, 348, 58);
		loginBox.add(loginTxtfield);
		loginTxtfield.setColumns(10);

		frmChat.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				controler.logout();
				e.getWindow().dispose();
			}
		});

		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controler.handleAuthentication(loginTxtfield.getText());
				loginContainer.setVisible(false);
				timer.start();

			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setBounds(188, 152, 89, 23);
		loginBox.add(btnNewButton);

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

			@Override
			public void actionPerformed(ActionEvent e ) {

				controler.sendMessage(writeMessage.getText());
				//move this v Line to the controler
				writeMessage.setText("");
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
			@Override
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
		btnPhotoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controler.refreshButton();
			}
		});
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

		errorLabel = new JLabel("");
		scrollPane_1.setColumnHeaderView(errorLabel);

		timer = new Timer(INTERVAL, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {

				//Refresh the panel
				controler.refreshButton();

			}
		});


	}

	public void setErrorMessage(String msg){
		errorLabel.setText(msg);
	}
}
