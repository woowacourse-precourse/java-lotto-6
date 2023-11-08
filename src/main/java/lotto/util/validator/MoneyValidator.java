package lotto.util.validator;

import lotto.config.Constant;
import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;

public class MoneyValidator {
    private final String money;

    public MoneyValidator(String money) {
        this.money = money;
        validateNumeric();
        validateRemainderZero();
    }

    private void validateNumeric() {
        if (!money.matches(Constant.PATTERN_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_IMPROPER_LETTER.getMessage());
        }
    }

    private void validateRemainderZero() {
        if (Integer.parseInt(money) % LottoConfig.LOTTO_UNIT_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_REMAINDER.getMessage());
        }
    }
}