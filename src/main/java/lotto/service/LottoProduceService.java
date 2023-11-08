package lotto.service;

import lotto.vo.Wallet;
import lotto.vo.Money;

public interface LottoProduceService {
    Wallet produceLotto(Money money);
}
