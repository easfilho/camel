package com.poc.camel.beans;

public class BeanCamel {
    public String map(String input) {
        return input.replace(",", "*");
    }
}
