package com.poc.camel.route.files.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyTransformRoute();
    }

    @Test
    public void testTransform() throws InterruptedException {
        Thread.sleep(5000);
        String input = "123,,456";
        String expected = "123**456";
        String output = (String) template.requestBody("direct:tranformInput", input);
        assertEquals(expected, output);
    }
}
