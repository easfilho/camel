package com.poc.camel.route.bean;

import com.poc.camel.beans.BeanCamel;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .bean(new BeanCamel(), "map")
                .to("mock:output");
    }
}
