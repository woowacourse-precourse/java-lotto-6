package lotto.model.lotto.publish;

import lotto.model.lotto.Lottos;
import lotto.model.money.Money;

public class LottoSeller {
    private final LottoSellingPolicy lottoSellingPolicy = new LottoSellingPolicy();
    private final LottosGenerator lottosGenerator = new LottosGenerator();

    public Lottos sell(Money purchasingMoney) {
        int countLottos = lottoSellingPolicy.calculateLottoCount(purchasingMoney);
        return lottosGenerator.generate(countLottos);
    }
}
