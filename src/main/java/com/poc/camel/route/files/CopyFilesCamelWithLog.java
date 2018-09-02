package com.poc.camel.route.files;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamelWithLog {
    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input1?noop=true")
                        .log("${body}")
                        //.to("log:?level=INFO&showBody=true&showHeaders=true")
                        .to("file:data/output");

                    from("file:data/input2?noop=true")
                            .log("${body}")
                            //.to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output");
                }
            });
            camelContext.start();
            Thread.sleep(5000);
            camelContext.stop();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
