package my.test.rest.ws.core;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

public class TestWsFacade extends JerseyTest {

	
	@Override
	protected Application configure() {
		return new ResourceConfig(WsApplication.class);
	}
	@Test
	public void testGetUsers() {
	
		WebTarget target = target("/api/v1/users");
		
		Builder request = target.request();
		
		Response response = request.get(Response.class);
		
		Assert.assertTrue("response must not be null", response != null);
		
		int status = response.getStatus();
		Assert.assertTrue(status == Status.OK.getStatusCode()); 
				
	}
}
