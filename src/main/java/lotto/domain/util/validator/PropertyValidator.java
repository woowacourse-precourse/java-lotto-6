package lotto.domain.util.validator;

import lotto.domain.config.PropertyConfig;
import lotto.domain.config.ValidatorConfig;

public class PropertyValidator {
    private static final String ERROR_MESSAGE = ValidatorConfig.ERROR_MESSAGE.getMessage();
    private static final String DIVIDED_ERROR_MESSAGE = "로또 구입 금액은 %d로 나누어 떨어져야 합니다.";
    private static final int PRICE_PER_LOTTO = PropertyConfig.PRICE_PER_LOTTO.getValue();

    private PropertyValidator() {
    }

    public static void validate(int property) {
        checkDivisible(property);
    }

    private static void checkDivisible(int property) {
        if (property % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + String.format(DIVIDED_ERROR_MESSAGE, PRICE_PER_LOTTO));
        }
    }
}
