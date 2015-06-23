package com.ofbizian.drools.standalone;

public class HelloWorld {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void showMessage() {
        System.out.println(message);
    }

}