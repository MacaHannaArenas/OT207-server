package com.alkemy.ong.exception;

public class ForbiddenExeption extends RuntimeException {
    private static final String DESCRIPTION = "Forbidden Exception";

    public ForbiddenExeption(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
