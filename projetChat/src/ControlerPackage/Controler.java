package ControlerPackage;


import java.util.ArrayList;

import dao.MessageBean;
import dao.UserBean;
import ihm.IHMSwing;
import utils.WsUtils;

public class Controler {

	private IHMSwing ihm;

	private static UserBean myself;
	private String errorMessage = "";



	private ArrayList<MessageBean> messageList;



	public Controler(){
		messageList = new ArrayList<>();
	}


	private void refreshScreen(){
		// TO Do Get all all informations and send it to IHM
		ihm.updateChat(messageList);
		ihm.setErrorMessage(errorMessage);

	}


	public void sendMessage(String msgTxt) {

		errorMessage = "";
		MessageBean msg = new MessageBean();
		msg.setContent(msgTxt);
		msg.setAuthor(getMyself());
		try {
			messageList = WsUtils.sendMessage(msg);

			// controler.refreshScreen();
			System.out.println(msg);
			//writeMessage.setText("Tapez votre message...");
			//Virer le TryCatch
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorMessage = e.getMessage();
		}

		refreshScreen();



	}


	public void refreshButton() {
		try {
			errorMessage = "";
			messageList = WsUtils.getMessageList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		refreshScreen();
	}




	private void addUser(UserBean user){
		try {
			WsUtils.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void handleAuthentication(String name){

		UserBean user = new UserBean();
		user.setName(name);


		// TO DO Verify is user already exists



		myself = user;
		myself.setLogged(true);
		addUser(user);

	}
	public void logout(){
		myself.setLogged(false);
	}


	/**
	 *
	 * Getters & Setters
	 */
	public static UserBean getMyself() {
		return myself;
	}


	public static void setMyself(UserBean myself) {
		Controler.myself = myself;
	}


	public void setIhm(IHMSwing ihm) {
		this.ihm = ihm;
	}

}
