package com.poc.camel.route.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

public class Xml2JsonRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:marshalEmployeeXml2Json")
                .to("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");

        XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName("Employee");


        from("direct:unMarshalEmployeeJson2Xml")
                .to("log:?level=INFO&showBody=true")
                //.unmarshal().xmljson()
                .unmarshal(xmlJsonDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
