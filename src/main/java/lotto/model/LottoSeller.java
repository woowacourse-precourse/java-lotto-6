package lotto.model;

public class LottoSeller {
    private final LottoSellingPolicy lottoSellingPolicy = new LottoSellingPolicy();
    private final LottosGenerator lottosGenerator = new LottosGenerator();

    public Lottos sell(Money purchasingMoney) {
        int countLottos = lottoSellingPolicy.calculateLottoCount(purchasingMoney);
        return lottosGenerator.generate(countLottos);
    }
}
