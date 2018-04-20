package model;

import java.util.ArrayList;

import dao.MessageBean;
import dao.UserBean;

public class dbUtils {

	private static ArrayList<MessageBean> listArrayMessage;
	private static ArrayList<UserBean> listArrayUser;

	public static boolean pushUser(UserBean user) {
		return true;
	}

	public static boolean pushMessage(MessageBean message) {
		listArrayMessage.add(message);
		System.out.println("push");
		return true;
	}

	public static ArrayList<MessageBean> getListArrayMessage() {
		return listArrayMessage;
	}

	public static ArrayList<UserBean> getListArrayUser() {
		return listArrayUser;
	}

	public static void addMessage(MessageBean msg) {

		listArrayMessage.add(msg);

	}

	public static void addUser(UserBean user) {

		listArrayUser.add(user);
	}
}
