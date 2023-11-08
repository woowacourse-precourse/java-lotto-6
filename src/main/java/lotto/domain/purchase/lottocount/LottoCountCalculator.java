package lotto.domain.purchase.lottocount;

import static lotto.domain.purchase.lottocount.CashPolicy.PRICE_PER_LOTTO;

public final class LottoCountCalculator {
    public static Integer divideByLottoPrice(Long cash) {
        return Math.toIntExact(cash / PRICE_PER_LOTTO);
    }
}
