package lotto.domin;

import lotto.view.ExceptionMessage;

import java.util.List;

//중복되는가
public  class Exception {

    public static void NumberCheck(String num)  throws IllegalArgumentException{
        boolean matches = num.matches("\\d+");
        if (!matches) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_TYPE_ERROR.getExceptionValue());
        }
    }
    //1~45
    public static void overNumber(int num) throws IllegalArgumentException{
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_RANGE.getExceptionValue());
        }
    }



}
