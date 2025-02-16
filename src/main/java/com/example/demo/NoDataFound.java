package com.example.demo;

public class NoDataFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NoDataFound(String s) {
        super(s);
    }
}
