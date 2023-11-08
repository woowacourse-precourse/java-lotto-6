package lotto.validator;

import lotto.constant.Lotto;
import lotto.constant.Message.ErrorMessage;

import java.util.Collections;
import java.util.List;

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
        if ((money % Lotto.PRICE_PER_LOTTO.getLottoNumber()) != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_THOUSAND_UNIT_MESSAGE.getErrorMessage());
        }
    }

    public void hasSixNumber(List<Integer> lotto) {
        if (lotto.size() != Lotto.NUMBER_OF_REQUIRED_LOTTO_NUMBER.getLottoNumber()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_SIX_THINGS_MESSAGE.getErrorMessage());
        }
    }
}
