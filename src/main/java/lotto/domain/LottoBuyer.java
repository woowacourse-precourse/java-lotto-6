package lotto.domain;

import java.util.List;

public class LottoBuyer {

    private final List<Lotto> lottoTickets;

    public LottoBuyer(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getPurchaseQuantity () {
        return lottoTickets.size();
    }
}
