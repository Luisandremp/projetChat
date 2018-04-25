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

import dao.ErrorBean;
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

		return Response.status(200).entity(GSON.toJson(dbUtils.getMessageList())).build();
	}

	// http://localhost:8080/projetChatServer/rest/MonService/User
	@Path("/User")
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Response getUserList() {

		ArrayList<UserBean> listUser = new ArrayList<UserBean>();
		return Response.status(200).entity(GSON.toJson(listUser)).build();

	}

	// http://localhost:8080/projetChatServer/rest/MonService/sendMessage
	@Path("/sendMessage")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response sendMessage(String receive) {

		try {
			System.out.println(receive);

			MessageBean msg = GSON.fromJson(receive, MessageBean.class);
			VerifyUtils.checkMessage(msg);
			dbUtils.insertValue(msg);
			return Response.status(200).entity(GSON.toJson(dbUtils.getMessageList())).build();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ErrorBean errorBean = new ErrorBean(e.getMessage());
			return Response.status(253).entity(GSON.toJson(errorBean)).build();

		}

	}

	// http://localhost:8080/projetChatServer/rest/MonService/addUser
	@Path("/addUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response sendUser(String receive) {

		System.out.println(receive);

		UserBean user = GSON.fromJson(receive, UserBean.class);
		dbUtils.insertValue(user);
		return Response.status(200).entity(GSON.toJson(dbUtils.getUserList())).build();

	}
}
