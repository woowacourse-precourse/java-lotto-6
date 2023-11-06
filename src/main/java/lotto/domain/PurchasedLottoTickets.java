package lotto.domain;

import java.util.List;
import java.util.StringJoiner;

public class PurchasedLottoTickets {

    private final List<Lotto> lottoTickets;

    public PurchasedLottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public String toString() {
        return String.join("", lottoTickets.toString());
    }
}
