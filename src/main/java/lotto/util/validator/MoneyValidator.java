package lotto.util.validator;

import lotto.config.Constant;
import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;

public class MoneyValidator extends InputValidator {

    public MoneyValidator(String money) {
        super(money);
        validateNumeric();
        validateRemainderZero();
    }

    private void validateNumeric() {
        if (!super.input.matches(Constant.PATTERN_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_IMPROPER_LETTER.getMessage());
        }
    }

    private void validateRemainderZero() {
        if (Integer.parseInt(super.input) % LottoConfig.LOTTO_UNIT_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_REMAINDER.getMessage());
        }
    }
}