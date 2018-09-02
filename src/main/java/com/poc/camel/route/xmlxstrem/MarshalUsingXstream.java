package com.poc.camel.route.xmlxstrem;

import com.poc.camel.domain.Employee;
import com.poc.camel.processors.CustomProcessorXstream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class MarshalUsingXstream extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:csvinput")
                .process(new CustomProcessorXstream())
                //.marshal().xstream()
                .marshal(populateStreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");

    }

    private XStreamDataFormat populateStreamDef() {
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        Map<String, String> aliases = new HashMap<>();
        aliases.put("Employee", Employee.class.getName());
        xStreamDataFormat.setAliases(aliases);
        return xStreamDataFormat;
    }

}