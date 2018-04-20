package utils;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.MessageBean;
import dao.UserBean;
import utils.HTTPUtils;

public class WsUtils {
	private final static String URL_BASE = "maBase";
	private final static String URL_GET_MESSAGE = "getmsg";
	private final static String URL_GET_USER  = "getuser";
	private final static String URL_SET_MESSAGE = "setmsg";
	private final static String URL_SET_USER = "setusr";
	
	
	public static ArrayList<MessageBean> getMessageList() throws Exception{
		String url = URL_BASE+URL_GET_MESSAGE;
		// Request
		String json = HTTPUtils.sendGetOkHttpRequest(url);

		// parse json
		Gson gson = new Gson();
		java.lang.reflect.Type type = new TypeToken<ArrayList<MessageBean>>(){
		}.getType();

		return gson.fromJson(json, type);
	
	}
	public static ArrayList<UserBean> getUserList() throws Exception{
		String url = URL_BASE+URL_GET_USER;
		// Request
		String json = HTTPUtils.sendGetOkHttpRequest(url);

		// parse json
		Gson gson = new Gson();
		java.lang.reflect.Type type = new TypeToken<ArrayList<UserBean>>(){
		}.getType();

		return gson.fromJson(json, type);		
	}
	public static ArrayList<MessageBean> updateMessageList(MessageBean msg) throws Exception{
		String url = URL_BASE+URL_SET_MESSAGE;;
		// Request
		Gson gson = new Gson();
		String paramJson = gson.toJson(msg);
		String json = HTTPUtils.sendPostOkHttpRequest(url, paramJson);

		java.lang.reflect.Type type = new TypeToken<ArrayList<MessageBean>>() {
		}.getType();

		return gson.fromJson(json, type);
		
	}
	public static ArrayList<UserBean> updateUserList(UserBean user) throws Exception{
		String url = URL_BASE+URL_SET_USER;;
		// Request
		Gson gson = new Gson();
		String paramJson = gson.toJson(user);
		String json = HTTPUtils.sendPostOkHttpRequest(url, paramJson);

		java.lang.reflect.Type type = new TypeToken<ArrayList<MessageBean>>() {
		}.getType();

		return gson.fromJson(json, type);
		
	}
}