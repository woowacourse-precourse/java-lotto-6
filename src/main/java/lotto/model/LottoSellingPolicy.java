package lotto.model;

import java.math.BigDecimal;

public class LottoSellingPolicy {
    public static final Money LOTTO_PRICE = new Money(1000);

    public int calcuateLottoCount(final Money purchasingMoney) {
        BigDecimal left = purchasingMoney.divideBy(LOTTO_PRICE);
        return left.intValue();
    }
}
