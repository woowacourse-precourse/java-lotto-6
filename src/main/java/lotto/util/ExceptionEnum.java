package lotto.util;

public enum ExceptionEnum{

    NOT_NUMBER_FORMAT("Your price Input is not a number format.");

    private final String NOTICE = "[ERROR] ";

    private String message;

    ExceptionEnum(String message){
        this.message = NOTICE + message;
    }

    public String getMessage(){
        return message;
    }

}
