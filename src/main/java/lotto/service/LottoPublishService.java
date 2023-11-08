package lotto.service;

import lotto.domain.LottoCollector;

public interface LottoPublishService {

    LottoCollector publish(int purchaseAmount);
}
