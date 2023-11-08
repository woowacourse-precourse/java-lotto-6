package lotto.util.validator;

import lotto.config.Constant;
import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;

public class BonusNumberValidator{
    private final String number;

    public BonusNumberValidator(String number) {
        this.number = number;
        validateNumeric();
        validateNumberInRange(number);
    }

    private void validateNumeric() {
        if (!number.matches(Constant.PATTERN_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_IMPROPER_LETTER.getMessage());
        }
    }

    private void validateNumberInRange(String inputNumber) {
        final int number = Integer.parseInt(inputNumber);
        if (number < LottoConfig.LOTTO_NUMBER_MIN.getNumber() || number > LottoConfig.LOTTO_NUMBER_MAX.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_NUMBER.getMessage());
        }
    }
}