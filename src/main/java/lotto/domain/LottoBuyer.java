package lotto.domain;

import java.util.List;

public class LottoBuyer {

    private final int purchaseAmount;
    private final LottoSeller lottoSeller;
    private List<Lotto> lottoTickets;

    public LottoBuyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoSeller = new LottoSeller();
        this.lottoTickets = lottoSeller.exchangeTickets(purchaseAmount);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getPurchaseQuantity () {
        return lottoTickets.size();
    }
}
