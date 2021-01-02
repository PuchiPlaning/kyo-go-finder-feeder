package com.fooqoo56.kyogofinder.feeder.appication.exception;

public class SpringBatchException extends Exception {


    private static final long serialVersionUID = -5624518839842556295L;

    /**
     * デフォルトコンストラクタ.
     */
    public SpringBatchException() {

    }

    public SpringBatchException(final String message) {
        super(message);
    }

    public SpringBatchException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
