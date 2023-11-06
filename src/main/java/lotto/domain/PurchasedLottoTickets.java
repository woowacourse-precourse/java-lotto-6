package lotto.domain;

import java.util.List;

public class PurchasedLottoTickets implements PurchasedTickets {

    private final List<Lotto> lottoTickets;

    public PurchasedLottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public String toString() {
        return String.join("", lottoTickets.toString());
    }

    @Override
    public int size() {
        return lottoTickets.size();
    }
}
