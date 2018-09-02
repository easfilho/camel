package com.poc.camel.route.gson;

import com.poc.camel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.collections.iterators.EmptyOrderedIterator;
import org.junit.Test;

public class MarshalUsingGsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalUsingGson() {
        Employee employee = new Employee("1", "Nome", "01/01/2001");
        String expected = "{\"id\":\"1\",\"name\":\"Nome\",\"joinDate\":\"01/01/2001\"}";
        String employeeJson = template.requestBody("direct:marshalGson", employee, String.class);
        assertEquals(expected,employeeJson);
    }
}
