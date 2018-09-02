package com.poc.camel.route.files.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {
        String expectedValue = "123:abc:2018/08/13\n" +
                               "456:def:2018/08/13\n";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();
    }
}
