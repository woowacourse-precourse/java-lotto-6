package lotto.domain;

import java.util.List;

public class LottoBuyer {

    private final int purchaseAmount;
    private List<Lotto> lottoTickets;
    private final LottoSeller lottoSeller;

    public LottoBuyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoSeller = new LottoSeller();
    }

    public void purchaseLottoTickets() {
        this.lottoTickets = lottoSeller.exchangeTickets(purchaseAmount);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getPurchaseQuantity () {
        return lottoTickets.size();
    }
}
