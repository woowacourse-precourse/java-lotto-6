package lotto.model;

import java.math.BigDecimal;

public class PurchasingMoney extends Money {
    private static final BigDecimal MOD = new BigDecimal(1000);

    public PurchasingMoney(String amount) {
        super(amount);
        validatePurchasingAmount(this.amount);
    }

    private void validatePurchasingAmount(BigDecimal money) {
        validateZero(money);
        validatePayAble(money);
    }

    private void validateZero(BigDecimal money) {
        if (money.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("금액은 0을 입력할 수 없습니다.");
        }
    }

    private void validatePayAble(BigDecimal money) {
        BigDecimal left = money.remainder(MOD);
        if (!left.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("1000원 단위로만 입력 가능합니다.");
        }
    }
}
