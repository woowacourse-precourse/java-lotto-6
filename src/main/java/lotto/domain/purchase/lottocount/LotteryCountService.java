package lotto.domain.purchase.lottocount;

import static lotto.domain.purchase.lottocount.CashPolicy.PRICE_PER_LOTTO;

public class LotteryCountService {
    public Integer getLottoCount(String cashInput) throws IllegalArgumentException {
        // 검증
        CashValidator.validateCashInput(cashInput);
        // 매핑
        Integer cash = CashMapper.mapToInteger(cashInput);
        // 개수 반환
        return (cash / PRICE_PER_LOTTO);
    }
}
