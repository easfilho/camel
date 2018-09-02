package com.poc.camel.route.xstream;

import com.poc.camel.domain.Employee;
import com.poc.camel.route.xmlxstrem.UnmarshallUsingXstream;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshallUsingXstreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshallUsingXstream();
    }

    @Test
    public void unmarshalXmlTest() throws InterruptedException {
        Employee employeeExpected = new Employee("123", "Nome do Boneco", "15/08/2018");
        String input = "<?xml version='1.0' encoding='UTF-8'?><Employee><id>123</id><name>Nome do Boneco</name><joinDate>15/08/2018</joinDate></Employee>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(employeeExpected.toString());
        template.sendBody("direct:xmlInput", input);
        assertMockEndpointsSatisfied();
    }
}
