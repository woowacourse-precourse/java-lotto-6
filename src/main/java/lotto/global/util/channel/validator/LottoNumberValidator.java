package lotto.global.util.channel.validator;

import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;

public abstract class LottoNumberValidator extends NumberValidator{

    private static final String REGEX_NUMBER_QUANTITY = "\\d{0,2}";
    private static final int NUMBER_LOWER_LIMIT = 1;
    private static final int NUMBER_UPPER_LIMIT = 45;


    protected void checkIsAvailableLottoNumber(String numberInput) {
        numberInput = numberInput.trim();
        checkIsNumber(numberInput);
        if (!numberInput.matches(REGEX_NUMBER_QUANTITY)){
            throw new GlobalException(GlobalError.NOT_AVAILABLE_LOTTO_NUMBER);
        }
        int number = Integer.parseInt(numberInput.trim());
        if (number < NUMBER_LOWER_LIMIT || number > NUMBER_UPPER_LIMIT) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_LOTTO_NUMBER);
        }
    }
}
