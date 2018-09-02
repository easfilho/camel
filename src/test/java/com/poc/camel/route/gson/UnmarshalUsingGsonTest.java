package com.poc.camel.route.gson;

import com.poc.camel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;

public class UnmarshalUsingGsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshalUsingGson();
    }

    @Test
    public void unmarshalUsinGson() {
        Employee expectedEmployee = new Employee("1", "Nome", "01/01/2001");
        String employeeJson = "{\"id\":\"1\",\"name\":\"Nome\",\"joinDate\":\"01/01/2001\"}";
        Employee responseEmployee = template.requestBody("direct:unmarshalGson", employeeJson, Employee.class);
        Assert.assertEquals(expectedEmployee.toString(), responseEmployee.toString());
    }
}
