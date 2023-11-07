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




}
