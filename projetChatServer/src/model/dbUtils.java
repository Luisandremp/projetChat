package model;

import java.util.ArrayList;

import dao.MessageBean;
import dao.UserBean;

public class dbUtils {

	private static ArrayList<MessageBean> listArrayMessage = new ArrayList<MessageBean>();
	private static ArrayList<UserBean> listArrayUser = new ArrayList<UserBean>();

	public static ArrayList<MessageBean> getMessageList() {
		return listArrayMessage;
	}

	public static ArrayList<UserBean> getUserList() {
		return listArrayUser;
	}

	public static boolean insertValue(MessageBean msg) {

		listArrayMessage.add(msg);
		return true;

	}

	public static boolean insertValue(UserBean user) {

		listArrayUser.add(user);
		return true;
	}
}
