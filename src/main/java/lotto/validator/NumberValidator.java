package lotto.validator;

import lotto.constant.LottoNumber;
import lotto.constant.Message.ErrorMessage;

public class NumberValidator {

    public void isDigit(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIGIT_MESSAGE.getErrorMessage());
        }
    }

    public void isNotThounsandWonUnit(String inputValue) {
        int money = Integer.parseInt(inputValue);
        if ((money % LottoNumber.PRICE_PER_LOTTO.getLottoNumber()) != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_THOUSAND_UNIT_MESSAGE.getErrorMessage());
        }
    }
}
