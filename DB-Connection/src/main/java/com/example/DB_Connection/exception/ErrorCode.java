package com.example.DB_Connection.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(10000, "Uncategorized Exception"),
    INVALID_KEY(1001, "Key is invalid"),
    USER_EXISTED(1002, "User already exists"),
    USER_NOT_EXISTED(1003, "User does not exist"),
    USERNAME_INVALID(1004, "Username must be at least 3 character"),
    PASSWORD_INVALID(1005, "Password must be at least 8 character"),
    UNAUTHENTICATED(1006, "Unauthenticated"),
    ;
    private final int code;
    private final String message;

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
