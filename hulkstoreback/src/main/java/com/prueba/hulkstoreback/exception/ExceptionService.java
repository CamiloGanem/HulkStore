package com.prueba.hulkstoreback.exception;

public class ExceptionService extends Exception{
    public ExceptionService() {
        super();
    }

    public ExceptionService(String message) {
        super(message);
    }

    public ExceptionService(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionService(Throwable cause) {
        super(cause);
    }

    protected ExceptionService(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
