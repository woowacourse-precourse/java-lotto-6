package lotto.service;

import lotto.domain.LottoPurchasePrice;
import lotto.domain.Lottos;

public class LottoService {

    private final Lottos lottos;

    public LottoService(Lottos lottos) {
        this.lottos = lottos;
    }

    public void saveLottos(LottoPurchasePrice lottoPurchasePrice) {
        lottos.saveLottos(lottoPurchasePrice);
    }


}
