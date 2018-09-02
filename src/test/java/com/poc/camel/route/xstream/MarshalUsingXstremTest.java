package com.poc.camel.route.xstream;

import com.poc.camel.route.xmlxstrem.MarshalUsingXstream;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstremTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXstream();
    }

    @Test
    public void masharXstreamTest() throws InterruptedException {
        String input = "123,Nome do Boneco,13/08/2018";
        String expected = "<?xml version='1.0' encoding='UTF-8'?><com.poc.camel.domain.Employee><id>123</id><name>Nome do Boneco</name><joinDate>13/08/2018</joinDate></com.poc.camel.domain.Employee>";
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);
        template.sendBody("direct:csvinput", input);
        assertMockEndpointsSatisfied();
    }

    @Test
    public void masharXstreamTest_Employee_alias() throws InterruptedException {
        String input = "123,Nome do Boneco,13/08/2018";
        String expected = "<?xml version='1.0' encoding='UTF-8'?><Employee><id>123</id><name>Nome do Boneco</name><joinDate>13/08/2018</joinDate></Employee>";
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);
        template.sendBody("direct:csvinput", input);
        assertMockEndpointsSatisfied();

    }
}
