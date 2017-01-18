package my.test.rest.ws.core;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import my.test.rest.ws.core.domain.MyUserPOJO;

@Path("/v1")
public class WsFacadeV1 {

	private UserService userService = new UserService();
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
	
		try {
			
			String response = jsonMapper.writeValueAsString(userService.getAllUsers());
			return getOk(response);
		} catch (Exception e) {
			e.printStackTrace();
			return getAppError(e.getMessage());
		} 
		
		
	}
	
	private Response getOk(final String data) {
		return Response.ok().entity(data).build();
		
	}
	
	private Response getCreated(final String uri, final String data) throws Exception {
		return Response.created(new URI(uri)).entity(data).build();
		
	}
	
	
	private Response getAppError(final String data) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(data).build();
	}
	
	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") final String id) {
		try {
			MyUserPOJO user = userService.getUser(id);
			String response = jsonMapper.writeValueAsString(user);
			
			return getOk(response);
		} catch (Exception e) {
			e.printStackTrace();
			return getAppError(e.getMessage());
		}
	}
	
	
	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response newUser(MultivaluedMap<String, String> formData, @Context HttpServletRequest request) throws Exception {
		
		return getCreated(request.getRequestURI() + "/12345", "New User has been created. User data: " + formData);
	}
	
	@PUT
	@Path("/users/{username}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateUser(@PathParam("username") final String userName, MultivaluedMap<String, String> formData) {
	
		return getOk("User " + userName + " has been updated. User data :" + formData);
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDefault() {
	  return "Service root";
	}
}
