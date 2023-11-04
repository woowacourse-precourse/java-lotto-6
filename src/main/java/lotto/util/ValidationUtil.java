package lotto.util;

import static lotto.constant.LottoNumber.PURCHASE_AMOUNT_COND;

import java.util.regex.Pattern;
import lotto.constant.message.ExceptionMessage;

public class ValidationUtil {
    private static final Pattern checkPattern = Pattern.compile("[0-9]+");

    private void validateNumberType (String input) {
        if(checkPattern.matcher(input).matches()){
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    private int validateDivision (String input) {
        int purchase = Integer.parseInt(input);
        if (purchase%PURCHASE_AMOUNT_COND.getNumber()!=0){
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_ERROR.getMessage());
        }
        return purchase;
    }
}
