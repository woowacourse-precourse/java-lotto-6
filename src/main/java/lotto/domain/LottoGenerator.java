package lotto.domain;

import lotto.util.LottoNumberGenerator;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final PurchaseMoney purchaseMoney;

    private LottoGenerator(LottoNumberGenerator lottoNumberGenerator, PurchaseMoney purchaseMoney) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.purchaseMoney = purchaseMoney;
    }

    public static LottoGenerator of(LottoNumberGenerator lottoNumberGenerator, PurchaseMoney purchaseMoney) {
        return new LottoGenerator(lottoNumberGenerator, purchaseMoney);
    }

    public Lottos createLottos() {
        return Lottos.of(purchaseMoney.buyCount(), lottoNumberGenerator);
    }

}
