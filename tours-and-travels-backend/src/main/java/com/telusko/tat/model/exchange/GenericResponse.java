package com.telusko.tat.model.exchange;

public record GenericResponse(String status, String message, Object info) {
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public static GenericResponse success(String message) {
        return new GenericResponse(SUCCESS, message, null);
    }

    public static GenericResponse error(String message) {
        return new GenericResponse(ERROR, message, null);
    }

    public static GenericResponse success(String message, Object info) {
        return new GenericResponse(SUCCESS, message, info);
    }

    public static GenericResponse error(String message, Object info) {
        return new GenericResponse(ERROR, message, info);
    }
}
