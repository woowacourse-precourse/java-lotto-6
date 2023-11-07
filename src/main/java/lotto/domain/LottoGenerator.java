package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoNumberGenerator;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final PurchaseMoney purchaseMoney;

    public LottoGenerator(LottoNumberGenerator lottoNumberGenerator, PurchaseMoney purchaseMoney) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.purchaseMoney = purchaseMoney;
    }

    public Lottos createLottos() {
        return Lottos.of(purchaseMoney.buyCount(), lottoNumberGenerator);
    }

}
