package lotto;


import static lotto.Constants.ErrorConstant.*;
import static lotto.Constants.LottoConstant.DIGIT_REGEX;
import static lotto.Constants.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.Constants.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.Objects;

public class LottoNumber {


    private LottoNumber(String input) {
        input = input.trim();
        isDigit(input);
    }


    private void isDigit(String input) {
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ERROR_INPUT_DIGIT);
        }
    }
}
