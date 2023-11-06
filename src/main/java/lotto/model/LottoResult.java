package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<PriceMoney, Integer> result = new HashMap<>();

    private LottoResult(Lottos lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            PriceMoney priceMoney = PriceMoney.of(lotto.sameNumberCounter(winningNumbers), lotto.hasNumber(winningNumbers.getBonusNumber()));
            result.merge(priceMoney, 1, Integer::sum);
        }
    }
    // of -> from
    public static LottoResult of(Lottos lottos, WinningNumbers winningNumbers) {
        return new LottoResult(lottos,winningNumbers);
    }

    public long calculatePrice() {
        long prize = 0L;
        for (PriceMoney priceMoney : result.keySet()) {
            prize += (long) result.get(priceMoney) * priceMoney.getPrice();
        }
        return prize;
    }

    public int getRankCount(PriceMoney priceMoney) {
        if (result.get(priceMoney) == null) {
            return 0;
        }
        return result.get(priceMoney);
    }
}
