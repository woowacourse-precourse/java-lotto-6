package lotto.view.convert;

import lotto.config.exception.ExceptionType;
import lotto.config.exception.InputException;

public class ConvertToInt {
    private final int value;

    public static ConvertToInt from(String value){
        return new ConvertToInt(value);
    }

    private ConvertToInt(String value){
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
