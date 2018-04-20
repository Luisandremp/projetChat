package controler;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dao.MessageBean;
import dao.UserBean;
import model.dbUtils;

@Path("/MonService")
public class WS {

	public static final Gson GSON = new Gson();

	// http://localhost:8080/projetChatServer/rest/MonService/helloWorld
	@Path("/helloWorld")
	@GET
	@Produces(MediaType.TEXT_PLAIN)

	public String hello() {

		return "HelloWorld";

	}

	// http://localhost:8080/projetChatServer/rest/MonService/viewMessageList
	@Path("/viewMessageList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Response getMessageList() {

		Gson gson = GSON;

		return Response.status(200).entity(gson.toJson(dbUtils.getListArrayMessage())).build();
	}

	// http://localhost:8080/projetChatServer/rest/MonService/viewUserList
	@Path("/viewUserList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Response getUserList() {

		ArrayList<UserBean> listUser = new ArrayList<UserBean>();
		Gson gson = GSON;
		return Response.status(200).entity(gson.toJson(listUser)).build();

	}

	// http://localhost:8080/projetChatServer/rest/MonService/updateMessageList
	@Path("/updateMessageList")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response updateMessage(String receive) {

		System.out.println(receive);

		Gson gson = GSON;
		MessageBean msg = gson.fromJson(receive, MessageBean.class);
		dbUtils.pushMessage(msg);
		return Response.status(200).entity(gson.toJson(dbUtils.getListArrayMessage())).build();

	}
}
