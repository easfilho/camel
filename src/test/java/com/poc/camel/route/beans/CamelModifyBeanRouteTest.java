package com.poc.camel.route.beans;

import com.poc.camel.route.bean.CamelModifyBeanRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import javax.swing.*;

public class CamelModifyBeanRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyBeanRoute();
    }

    @Test
    public void testeRouteBuilder() {
        String input = "123,456,789";
        String expected = "123*456*789";
        String output = (String) template.requestBody("direct:beanInput", input);
        assertEquals(expected, output);
    }
}
