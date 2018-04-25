package utils;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.MessageBean;
import dao.UserBean;

public class WsUtils {
	private final static String URL_BASE = "http://192.168.20.21:8080/projetChatServer/rest/MonService";
	private final static String URL_GET_MESSAGE = "/Message";
	private final static String URL_GET_USER  = "/User";
	private final static String URL_SET_MESSAGE = "/sendMessage";
	private final static String URL_SET_USER = "/addUser";

	public static final Gson gson = new Gson();


	public static ArrayList<MessageBean> getMessageList() throws Exception{
		String url = URL_BASE+URL_GET_MESSAGE;
		// Request
		String json = HTTPUtils.sendGetOkHttpRequest(url);

		// parse json

		java.lang.reflect.Type type = new TypeToken<ArrayList<MessageBean>>(){
		}.getType();

		return gson.fromJson(json, type);

	}
	public static ArrayList<UserBean> getUserList() throws Exception{
		String url = URL_BASE+URL_GET_USER;
		// Request
		String json = HTTPUtils.sendGetOkHttpRequest(url);

		// parse json
		java.lang.reflect.Type type = new TypeToken<ArrayList<UserBean>>(){
		}.getType();

		return gson.fromJson(json, type);
	}
	public static ArrayList<MessageBean> sendMessage(MessageBean msg) throws Exception{
		String url = URL_BASE+URL_SET_MESSAGE;;
		// Request
		String paramJson = gson.toJson(msg);
		String json = HTTPUtils.sendPostOkHttpRequest(url, paramJson);

		java.lang.reflect.Type type = new TypeToken<ArrayList<MessageBean>>() {
		}.getType();

		return gson.fromJson(json, type);

	}
	public static ArrayList<UserBean> addUser(UserBean user) throws Exception{
		String url = URL_BASE+URL_SET_USER;;
		// Request
		String paramJson = gson.toJson(user);
		String json = HTTPUtils.sendPostOkHttpRequest(url, paramJson);

		java.lang.reflect.Type type = new TypeToken<ArrayList<MessageBean>>() {
		}.getType();

		return gson.fromJson(json, type);

	}
}