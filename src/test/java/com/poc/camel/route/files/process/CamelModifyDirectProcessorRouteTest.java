package com.poc.camel.route.files.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void processorDirectTest() {
        String expected = "123:dilip:12jan2017";
        String input = "123,dilip,12jan2017";
        String output = (String) template.requestBody("direct:processorInput", input);
        assertEquals(expected, output);
    }
}
