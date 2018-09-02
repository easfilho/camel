package com.poc.camel.processors;

import com.poc.camel.domain.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.StringTokenizer;

public class CustomProcessorXstream implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        StringTokenizer tokenizer = new StringTokenizer(body, ",");
        Employee employee = new Employee();
        while (tokenizer.hasMoreElements()) {
            employee.setId(tokenizer.nextElement().toString());
            employee.setName(tokenizer.nextElement().toString());
            employee.setJoinDate(tokenizer.nextElement().toString());
        }
        exchange.getIn().setBody(employee);
    }
}
