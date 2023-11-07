package lotto.service;

import lotto.domain.LottoCount;
import lotto.domain.Lottos;

public interface LottoGameService {
    LottoCount computeLottoCount(String purchaseAmount);

    Lottos generateLottos(LottoCount lottoCount);
}
