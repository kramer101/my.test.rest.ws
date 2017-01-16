package my.test.rest.ws.core;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import my.test.rest.ws.core.domain.MyUserPOJO;

@Path("/v1")
public class WsFacadeV1 {

	private UserService userService = new UserService();
	private ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
	
		try {
			
			String response = mapper.writeValueAsString(userService.getAllUsers());
			return getOk(response);
		} catch (Exception e) {
			e.printStackTrace();
			return getAppError(e.getMessage());
		} 
		
		
	}
	
	private Response getOk(final String data) {
		return Response.ok().entity(data).build();
		
	}
	
	private Response getAppError(final String data) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(data).build();
	}
	
	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") final String id) {
		try {
			MyUserPOJO user = userService.getUser(id);
			String response = mapper.writeValueAsString(user);
			
			return getOk(response);
		} catch (Exception e) {
			e.printStackTrace();
			return getAppError(e.getMessage());
		}
	}
	
	
	@POST
	@Path("/newuser")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String newUser(MultivaluedMap<String, String> formData) {
		
		return "form data: " + formData;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getDefault() {
	  return "Service root";
	}
}
