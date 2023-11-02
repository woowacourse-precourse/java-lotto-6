package lotto.service;

import lotto.domain.Wallet;
import lotto.vo.Money;

public interface LottoProduceService {
    Wallet produceLotto(Money money);
}
