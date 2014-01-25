dummy-rest-api
==============

Sample of REST APIs using: Spring Security + Jersey for Rest + JUnit Tests

This sample reproduces the problem we are trying to solve in this Stack Overflow question:
http://stackoverflow.com/questions/19729981/how-to-setup-jerseytest-with-spring-security

When using unit tests for the protected endpoint, the following exception occurs:

    mvn clean compile
    mvn -Dtest=TestApiEndpoints test
    ...
    Caused by: org.springframework.security.authentication.AuthenticationCredentialsNotFoundException: An Authentication object was not found in the SecurityContext
    	at org.springframework.security.access.intercept.AbstractSecurityInterceptor.credentialsNotFound(AbstractSecurityInterceptor.java:339)
        at org.springframework.security.access.intercept.AbstractSecurityInterceptor.beforeInvocation(AbstractSecurityInterceptor.java:198)
        at org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor.invoke(MethodSecurityInterceptor.java:60)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
    	at org.springframework.aop.framework.Cglib2AopProxy$DynamicAdvisedInterceptor.intercept(Cglib2AopProxy.java:621)
    	at com.dummy.DummyRestApi$$EnhancerByCGLIB$$baa585bb_2.getProtectedData(<generated>)

