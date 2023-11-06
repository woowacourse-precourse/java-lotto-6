package lotto.Util;

import lotto.Constants.ExceptionMessage;

public class Converter {
    private static final long MAX_VALUE = 2147483647L;
    private static final int SPLIT_LIMIT = -1;
    private static final String SPACE = " ";
    private static final String NULL = "";
    private static final String KOMA = ",";

    private void checkEmpty(String amount){
        if (amount.isEmpty()){
            throw ExceptionMessage.INPUT_EMPTY.throwexception();
        }
    }

    private void checkType(String amount){
        if (amount.matches(".*\\D.*")){
            throw ExceptionMessage.INPUT_TYPE.throwexception();
        }
    }

    private void checkValueOverflow(String amount){
        long max = Long.parseLong(amount);
        if (max > MAX_VALUE){
            throw ExceptionMessage.NUMBER_OVERFLOW.throwexception();
        }
    }
}
