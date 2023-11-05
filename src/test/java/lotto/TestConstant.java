package lotto;

import lotto.config.TestLottoConfig;
import lotto.constant.LottoConstraint;
import java.util.List;

public class TestConstant {
    public static final TestLottoConfig testLottoConfig = new TestLottoConfig();
    public static final List<Integer> normalNumbers = List.of(1, 2, 3, 4, 5, 6);
    public static final int minPaymentAmount
            = LottoConstraint.PRICE_PER_LOTTO.getValue() * LottoConstraint.MIN_PURCHASE_QUANTITY.getValue();
}
