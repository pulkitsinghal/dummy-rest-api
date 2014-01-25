package com.dummy.test;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * Unit Test, doesn't work without disabling spring-security on "GET invoices" endpoint
 * I posted a Q on stackoverflow:
 * http://stackoverflow.com/questions/19729981/how-to-setup-jerseytest-with-spring-security
 */
public class TestApiEndpoints extends SetupJerseyTest {

	@Test
	public void testUnprotectedEndpoint()
	{
		WebResource webResource = resource();

		ClientResponse clientResponse =
				webResource.path("dummy/unprotected/endpoint/")
				.get(ClientResponse.class);
		String responseMsg = clientResponse.getEntity(String.class);
		System.out.println(responseMsg);

		Assert.assertTrue(clientResponse.getStatus() < 300);
		Assert.assertNotNull(responseMsg);
	}

	@Test
	public void testProtectedEndpoint()
	{
		WebResource webResource = resource();

		webResource.addFilter(new HTTPBasicAuthFilter("username", "password"));

		ClientResponse clientResponse =
				webResource.path("dummy/protected/endpoint/")
				.get(ClientResponse.class);
		String responseMsg = clientResponse.getEntity(String.class);
		System.out.println(responseMsg);

		Assert.assertTrue(clientResponse.getStatus() < 300);
		Assert.assertNotNull(responseMsg);
	}
}