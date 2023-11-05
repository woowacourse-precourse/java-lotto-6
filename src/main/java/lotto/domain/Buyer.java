package lotto.domain;

import java.util.List;

public class Buyer {

    private int purchaseAmount;
    private int purchaselottoQuantity;
    private List<Lotto> lottoTickets;

    public Buyer(int amount, int quantity, List<Lotto> lottoTickets) {
        this.purchaseAmount = amount;
        this.purchaselottoQuantity = quantity;
        this.lottoTickets = lottoTickets;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaselottoQuantity() {
        return purchaselottoQuantity;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
