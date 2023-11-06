package lotto.domain;

import static lotto.domain.constants.LottoConfig.LOTTO_COUNT;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(final Buyer buyer) {
        this.lottoTickets = generateLottoTickets(LOTTO_COUNT.getValue());
    }

    private List<LottoTicket> generateLottoTickets(int ticketAmount) {
        return null;
    }

    public static LottoTickets create(final Buyer buyer) {
        return new LottoTickets(buyer);
    }
}
