package com.dummy.test;

import org.springframework.web.context.ContextLoaderListener;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class SetupJerseyTest extends JerseyTest {

	@Override
	protected AppDescriptor configure() {
		System.setProperty("enableLogging", "true");

		/**
		 * If instead of simply configuring the test client,
		 * we want to get really crazy and replace it, then this might be helpful:
		 * https://blogs.oracle.com/PavelBucek/entry/replacing_client_used_in_jersey
		 */
		return new WebAppDescriptor.Builder("com.dummy")
				.initParam(JSONConfiguration.FEATURE_POJO_MAPPING, "true")
				// .contextPath("/")
				.contextPath("dummy-rest-api")
				.servletPath("rest") // unlike web.xml, can we only configure one servlet at a time for tests?
				.servletClass(SpringServlet.class)
				.contextParam("contextConfigLocation", "classpath:spring/applicationContext.xml")
				.contextListenerClass(ContextLoaderListener.class)
				.build();
	}

}