package lotto.model;

import java.math.BigDecimal;

public class LottoSeller {
    private final LottoSellingPolicy lottoSellingPolicy = new LottoSellingPolicy();
    private final LottosGenerator lottosGenerator = new LottosGenerator();

    public Lottos sell(Money purchasingMoney) {
        int countLottos = lottoSellingPolicy.calcuateLottoCount(purchasingMoney);
        return lottosGenerator.generate(countLottos);
    }
}
