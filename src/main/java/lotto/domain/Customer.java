package lotto.domain;

import java.util.List;

public class Customer {
    private final Cash cash;
    private final LottoSeller lottoSeller;
    private List<Lotto> lottos;

    public Customer(Cash cash, LottoSeller lottoSeller) {
        this.cash = cash;
        this.lottoSeller = lottoSeller;
    }

    public void purchaseLottos() {
        this.lottos = lottoSeller.sellLottos(cash);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
