package utils;

import dao.ErrorBean;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HTTPUtils {
	public static String sendGetOkHttpRequest(String url) throws Exception {

		System.out.println("URL: " + url);
		OkHttpClient client = new OkHttpClient();

		// creation de la requete
		Request request = new Request.Builder().url(url).build();
		// Executionde la requ�te
		Response response = client.newCall(request).execute();

		// Analyse du code retour
		if (response.code() < 200 || response.code() > 299) {
			throw new Exception("R�ponse du serveur incorrect : " + response.code());
		} else {
			// R�sultat de la requete.
			return response.body().string();
		}
	}

	public static String sendPostOkHttpRequest(String url, String paramJson) throws Exception {
		System.out.println("Url: " + url);
		OkHttpClient client = new OkHttpClient();
		MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		// Corps de la requ�te
		RequestBody body = RequestBody.create(JSON, paramJson);

		// Cr�ation de la requete
		Request request = new Request.Builder().url(url).post(body).build();
		// Executionde la requ�te
		Response response = client.newCall(request).execute();
		// Analyse du code retour

		if (response.code() < 200 || response.code() > 299) {
			throw new Exception("R�ponse du serveur incorrect : " + response.code());
		}
		else if(response.code() == 253){
			ErrorBean errorBean =	WsUtils.gson.fromJson(response.body().string(), ErrorBean.class);
			throw new Exception("Une erreur est survenue : " + errorBean.getMsg());

		}
		else {

			// R�sultat de la requete.
			return response.body().string();
		}
	}
}