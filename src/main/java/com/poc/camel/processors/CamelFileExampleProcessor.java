package com.poc.camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchage: " + exchange.getIn().getBody());
        GenericFile<File> genericFile = (GenericFile<File>) exchange.getIn().getBody();
        if(genericFile != null) {
            String readLine = null;
            String newValue = "";
            FileReader fileReader = new FileReader(genericFile.getFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((readLine = bufferedReader.readLine()) != null) {
                newValue = newValue.concat(readLine.replace(",", ":")).concat("\n");
            }
            exchange.getIn().setBody(newValue);
        }
    }
}
