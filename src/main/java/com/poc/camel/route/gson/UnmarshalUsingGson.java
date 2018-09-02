package com.poc.camel.route.gson;

import com.poc.camel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class UnmarshalUsingGson extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:unmarshalGson")
                .unmarshal(gsonDataFormat)
                .to("mock:output");
    }
}
