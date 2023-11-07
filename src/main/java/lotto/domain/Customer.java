package lotto.domain;

import java.util.List;

public class Customer {
    private final Cash cash;
    private final LottoSeller lottoSeller;

    public Customer(Cash cash, LottoSeller lottoSeller) {
        this.cash = cash;
        this.lottoSeller = lottoSeller;
    }

    public List<Lotto> purchaseLottos() {
        return lottoSeller.sellLottos(cash);
    }
}
