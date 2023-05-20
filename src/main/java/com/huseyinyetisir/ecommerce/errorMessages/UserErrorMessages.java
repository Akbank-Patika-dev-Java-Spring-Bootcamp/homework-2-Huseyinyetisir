package com.huseyinyetisir.ecommerce.errorMessages;



public enum UserErrorMessages implements BaseErrorMessage {
    USER_NOT_FOUND("User not found!");

    private String message;


    UserErrorMessages(String message){this.message =message;}

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString(){
        return message;
    }
}
