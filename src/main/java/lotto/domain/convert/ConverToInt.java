package lotto.domain.convert;

import lotto.exception.ExceptionType;
import lotto.exception.InputException;

public class ConverToInt {
    private final int value;

    public static ConverToInt from(String value){
        return new ConverToInt(value);
    }

    private ConverToInt(String value){
        validateInput(value);
        this.value = Integer.parseInt(value);
    }

    private void validateInput(String value) {
        if(isOnlyNumber(value)){
            throw new InputException(ExceptionType.ERROR_CONVERT_TO_INT_ONLY_NUMBER);
        }
    }

    private boolean isOnlyNumber(String value) {
        return !value.matches("[0-9]+");
    }

    public int getValue(){
        return this.value;
    }
}
