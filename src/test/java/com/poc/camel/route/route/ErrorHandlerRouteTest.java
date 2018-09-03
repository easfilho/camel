package com.poc.camel.route.route;

import com.poc.camel.route.error.ErrorHandlerRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class ErrorHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void testErrorHandler() throws InterruptedException {
        Thread.sleep(5000);
        String reponse = template.requestBody("direct:sampleInput", null, String.class);
    }
}
