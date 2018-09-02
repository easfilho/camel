package com.poc.camel.route.files.process;

import com.poc.camel.processors.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Recieved message before process ${body}")
                .process(new CamelDirectExampleProcessor())
                .log("Recieved message after process ${body}")
                .to("file:data/output?fileName=output.txt");
    }
}
