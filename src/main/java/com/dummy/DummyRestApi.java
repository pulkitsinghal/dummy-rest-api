package com.dummy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Path("/dummy")
@Component
public class DummyRestApi {

	@GET
	@Path("/protected/endpoint/")
	@PreAuthorize("hasRole('dummy')")
	public Response getProtectedData(){
		return Response.ok("secret").build();
	}

	@GET
	@Path("/unprotected/endpoint/")
	public Response getMyEndpoint(){
		return Response.ok("common knowledge").build();
	}

}
