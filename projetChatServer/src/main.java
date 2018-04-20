import java.util.ArrayList;

import dao.MessageBean;
import dao.UserBean;

public class main {

	public static void main(String[] args) {
		try {
			// get MessageArrayList
			ArrayList<MessageBean> msgList = new ArrayList<MessageBean>();
			MessageBean msg = new MessageBean();
			msg.setContent("test");
			UserBean userBean = new UserBean();
			userBean.setName("Billy");
			userBean.setLogged(true);
			msg.setAuthor(userBean);
			msgList.add(msg);
			System.out.println(msgList.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
