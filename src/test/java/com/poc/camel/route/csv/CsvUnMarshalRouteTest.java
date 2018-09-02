package com.poc.camel.route.csv;

import com.poc.camel.domain.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class CsvUnMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvUnMarshalRoute();
    }

    @Test
    public void testCsvMarshalRoute() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(5000);
        List<Employee> employees = (List<Employee>) exchange.getIn().getBody();
        employees.get(1).toString();
        assertFalse(employees.isEmpty());
    }
}
