package lotto.service;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;

public class LottoGameService {
    private LottoGenerator lottoGenerator;

    public LottoGameService() {
        this.lottoGenerator = new LottoGenerator();
    }

    public Lottos buyLottos(LottoPurchase lottoPurchase) {
        return lottoGenerator.buyLottos(lottoPurchase);
    }

}
