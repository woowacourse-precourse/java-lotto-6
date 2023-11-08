package lotto.validator;

import lotto.constant.Lotto;
import lotto.constant.Message.ErrorMessage;
import lotto.util.StringUtil;

public class StringValidator {
    private StringUtil stringUtil = new StringUtil();
    private NumberValidator numberValidator = new NumberValidator();

    public void isNotNullValidate(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_MESSAGE.getErrorMessage());
        }
    }

    public void hasNotBlankValidate(String inputValue) {
        if (inputValue.replace(" ", "").length() != inputValue.length()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_BLANK_MESSAGE.getErrorMessage());
        }
    }

    public String[] isSeparateByComma(String inputValue) {
        try {
            return stringUtil.ConvertStringToArray(inputValue);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_COMMA_SEPARATOR_MESSAGE.getErrorMessage());
        }
    }

    public void isSixNumber(String[] buyerLottoNumbers) {
        if (buyerLottoNumbers.length != Lotto.NUMBER_OF_REQUIRED_LOTTO_NUMBER.getLottoNumber()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_SIX_THINGS_MESSAGE.getErrorMessage());
        }
    }

    public void isAllDigit(String[] buyerLottoNumbers) {
        for (String number : buyerLottoNumbers) {
            numberValidator.isDigit(number);
        }
    }
}