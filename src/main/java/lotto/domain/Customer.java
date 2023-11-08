package lotto.domain;

import lotto.dto.Lottos;

public class Customer {
    private final Cash cash;
    private final LottoSeller lottoSeller;

    public Customer(Cash cash, LottoSeller lottoSeller) {
        this.cash = cash;
        this.lottoSeller = lottoSeller;
    }

    public Lottos purchaseLottos() {
        return lottoSeller.sellLottos(cash);
    }
}
