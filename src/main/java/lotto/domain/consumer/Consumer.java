package lotto.domain.consumer;


import lotto.domain.common.Lotto;

import java.util.List;

public record Consumer(Price price, List<Lotto> consumerLottos, Count count) {

    public Consumer {

    }
}

