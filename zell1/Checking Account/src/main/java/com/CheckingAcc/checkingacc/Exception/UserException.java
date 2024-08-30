package com.CheckingAcc.checkingacc.Exception;

public class UserException extends RuntimeException {

    public UserException(String message) {
        super(message);

    }
    public static class UserNotFoundException extends UserException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    public static class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
}
