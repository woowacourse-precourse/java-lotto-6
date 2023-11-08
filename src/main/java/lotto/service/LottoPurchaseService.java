package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;

public final class LottoPurchaseService {
    private final LottoStore lottoStore;

    public LottoPurchaseService(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public List<Lotto> buyLottos(long investmentAmount) {
        return lottoStore.purchaseLottos(investmentAmount);
    }
}
