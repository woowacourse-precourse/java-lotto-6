package lotto.utils;

import java.math.BigDecimal;

public class AmountValidator {
    private static final BigDecimal MOD = new BigDecimal(1000);

    public static void validateAmount(BigDecimal money) {
        AmountValidator.validateZero(money);
        AmountValidator.validatePayAble(money);
    }
    private static void validateZero(BigDecimal money) {
        if (money.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("금액은 0을 입력할 수 없습니다.");
        }
    }

    private static void validatePayAble(BigDecimal money) {
        BigDecimal left = money.remainder(MOD);
        if (!left.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("1000 단위로만 입력 가능합니다.");
        }
    }
}
