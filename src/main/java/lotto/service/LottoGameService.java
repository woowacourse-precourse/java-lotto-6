package lotto.service;

import lotto.domain.LottoCount;

public interface LottoGameService {
    LottoCount computeLottoCount(String purchaseAmount);
}
