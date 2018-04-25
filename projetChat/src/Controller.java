
 
import dao.MessageBean;
import dao.UserBean;
import ihm.IHMSwing;
import utils.WsUtils;

public class Controller {
 private IHMSwing ihm;
 private static UserBean myself;
 
 private void refreshScreen(){
	 // TO Do Get all all informations and send it to IHM
	 try {
		 //ihm.updateChat(WsUtils.getMessageList());
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 
 
 public void SendMsg(String msgTxt) throws Exception{
	 MessageBean msg = new MessageBean(); 
	 msg.setContent(msgTxt);
	 WsUtils.sendMessage(msg);
 }
 public void addUser(String name) throws Exception{
	 UserBean user = new UserBean(); 
	 user.setName(name);
	 WsUtils.addUser(user); 
 }
 private void handleAthentication(String name){
	// TO DO Verify is user already exists 
 }
 
 
 /**
  * 
  * Getters & Setters
  */
public static UserBean getMyself() {
	return myself;
}


public static void setMyself(UserBean myself) {
	Controller.myself = myself;
}


public void setIhm(IHMSwing ihm) {
	this.ihm = ihm;
}
 
}
