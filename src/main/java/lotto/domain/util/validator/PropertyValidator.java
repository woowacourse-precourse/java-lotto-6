package lotto.domain.util.validator;

import lotto.domain.config.PropertyConfig;

public class PropertyValidator {
    private static final int PRICE_PER_LOTTO = PropertyConfig.PRICE_PER_LOTTO.getValue();

    public static void validate(int property) {
        checkDivisible(property);
    }

    private static void checkDivisible(int property) {
        if (property % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + PRICE_PER_LOTTO + "로 나누어 떨어져야 합니다.");
        }
    }
}
