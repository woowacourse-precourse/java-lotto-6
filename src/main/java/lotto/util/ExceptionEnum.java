package lotto.util;

public enum ExceptionEnum{

    NOT_NUMBER_FORMAT("Your price Input is not a number format."),
    INVALID_PURCHASE_PRICE_UNIT("The purchase price should be in 1000 units."),
    INVALID_NUMBERS_SIZE("Lotto numbers size should be 6."),
    INVALID_NUMBER_RANGE("Number should be between 1 and 45.");

    private static final String NOTICE = "[ERROR] ";

    private String message;

    ExceptionEnum(String message){
        this.message = NOTICE + message;
    }

    public String message(){
        return this.message;
    }

}
