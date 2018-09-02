package com.poc.camel.route.gson;

import com.poc.camel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:marshalGson")
                .marshal(gsonDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
