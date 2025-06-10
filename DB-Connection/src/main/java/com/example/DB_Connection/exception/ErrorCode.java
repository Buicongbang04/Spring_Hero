package com.example.DB_Connection.exception;

public enum ErrorCode{
    UNCATEGORIZED_EXCEPTION(10000,"Uncategorized Exception"),
    INVALID_KEY(1001, "Key is invalid"),
    USER_EXISTED(1002, "User already exists"),
    USERNAME_INVALID(1003, "Username must be at least 3 character"),
    PASSWORD_INVALID(1004, "Password must be at least 8 character"),
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
