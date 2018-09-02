package com.poc.camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelDirectExampleProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        try {
            String body = (String) exchange.getIn().getBody();
            exchange.getIn().setBody(body.replace(",", ":"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
