package com.poc.camel.route.xmlxstrem;

import com.poc.camel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class UnmarshallUsingXstream extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        Map<String, String> aliases = new HashMap<>();
        aliases.put("Employee", Employee.class.getName());
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        xStreamDataFormat.setAliases(aliases);
        xStreamDataFormat.setPermissions(Employee.class);

        from("direct:xmlInput")
                .unmarshal(xStreamDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
