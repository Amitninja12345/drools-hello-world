package com.ofbizian.drools.domain;

/**
 * User: bibryam
 * Date: 23/06/15
 */
public class Product {
    private double value;
    private String code;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "value=" + value +
                ", code='" + code + '\'' +
                '}';
    }
}
