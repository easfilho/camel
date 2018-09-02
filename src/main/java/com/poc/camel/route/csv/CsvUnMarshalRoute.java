package com.poc.camel.route.csv;

import com.poc.camel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvUnMarshalRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat("com.poc.camel.domain");

        from("file:data/csv/input?fileName=file.txt&noop=true")
                .unmarshal()
                .csv()
                .log("unmarshaled message: ${body}")
                .to("direct:output");
    }
}
