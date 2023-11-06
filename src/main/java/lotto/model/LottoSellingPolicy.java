package lotto.model;

import java.math.BigDecimal;

public class LottoSellingPolicy {
    public static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);

    public int calcuateLottoCount(final BigDecimal purchasingMoney) {
        BigDecimal left = purchasingMoney.divide(LOTTO_PRICE);
        return left.intValue();
    }
}
