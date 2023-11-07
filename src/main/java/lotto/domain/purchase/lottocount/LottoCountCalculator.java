package lotto.domain.purchase.lottocount;

import static lotto.domain.purchase.lottocount.CashPolicy.PRICE_PER_LOTTO;

public final class LottoCountCalculator {
    public static Integer divideByLottoPrice(Integer cash) {
        return cash / PRICE_PER_LOTTO;
    }
}
