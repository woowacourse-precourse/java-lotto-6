package lotto.global.util.channel.validator;

import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;

/**
 * @see lotto.global.util.channel.validator.NumberValidator
 */
public abstract class LottoNumberValidator extends NumberValidator{

    private static final String REGEX_NUMBER_QUANTITY = "^([1-9]{0})|(\\d{0,2})?";//"\\d{0,2}";
    private static final int NUMBER_LOWER_LIMIT = 1;
    private static final int NUMBER_UPPER_LIMIT = 45;


    /** 로또 번호 요구사항 준수여부를 검사합니다. */
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
