package com.poc.camel.route.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class Xml2JsonRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new Xml2JsonRoute();
    }

    @Test
    public void marshalEmployee2JsonXml() {
        String input = "<?xml version='1.0' encoding='UTF-8'?><Employee><id>123</id><name>Nome do Boneco</name><joinDate>15/08/2018</joinDate></Employee>";
        String expected = "{\"id\":\"123\",\"name\":\"Nome do Boneco\",\"joinDate\":\"15/08/2018\"}";
        String response = template.requestBody("direct:marshalEmployeeXml2Json", input, String.class);
        assertEquals(expected, response);
    }

    @Test
    public void unmarshalEmployeeJson2Xml() {
        String input = "{\"id\":\"123\",\"name\":\"Nome do Boneco\",\"joinDate\":\"15/08/2018\"}";
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<Employee><id>123</id><joinDate>15/08/2018</joinDate><name>Nome do Boneco</name></Employee>\r\n";
        String response = template.requestBody("direct:unMarshalEmployeeJson2Xml", input, String.class);
        System.out.println(response);
        assertEquals(expected, response);
    }
}
