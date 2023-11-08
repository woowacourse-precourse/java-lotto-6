package lotto.model.lotto.publish;

import java.math.BigDecimal;
import lotto.model.money.Money;

public class LottoSellingPolicy {
    public static final Money LOTTO_PRICE = new Money("1000");

    public int calculateLottoCount(final Money purchasingMoney) {
        BigDecimal left = purchasingMoney.divideBy(LOTTO_PRICE);
        return left.intValue();
    }
}
