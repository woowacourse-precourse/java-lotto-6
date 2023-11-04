package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTickets;

    public LottoTicket(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
}