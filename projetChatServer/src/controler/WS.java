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

	// http://localhost:8080/projetChatServer/rest/MonService/Message
	@Path("/Message")
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Response getMessageList() {

		Gson gson = GSON;
		return Response.status(200).entity(gson.toJson(dbUtils.getMessageList())).build();
	}

	// http://localhost:8080/projetChatServer/rest/MonService/User
	@Path("/User")
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Response getUserList() {

		ArrayList<UserBean> listUser = new ArrayList<UserBean>();
		Gson gson = GSON;
		return Response.status(200).entity(gson.toJson(listUser)).build();

	}

	// http://localhost:8080/projetChatServer/rest/MonService/sendMessage
	@Path("/sendMessage")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response sendMessage(String receive) {

		System.out.println(receive);

		Gson gson = GSON;
		MessageBean msg = gson.fromJson(receive, MessageBean.class);
		dbUtils.insertValue(msg);
		return Response.status(200).entity(gson.toJson(dbUtils.getMessageList())).build();

	}

	// http://localhost:8080/projetChatServer/rest/MonService/addUser
	@Path("/addUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response sendUser(String receive) {

		System.out.println(receive);

		Gson gson = GSON;
		UserBean user = gson.fromJson(receive, UserBean.class);
		dbUtils.insertValue(user);
		return Response.status(200).entity(gson.toJson(dbUtils.getUserList())).build();

	}
}
