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
}
