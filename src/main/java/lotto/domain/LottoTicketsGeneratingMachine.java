package lotto.domain;

import lotto.dto.LottoTickets;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketsGeneratingMachine {

    public LottoTickets generateRandomLottoTickets(TicketSize ticketSize) {
        List<Lotto> lottoTickets = IntStream.range(0, ticketSize.getTicketSize())
                .mapToObj(cnt -> Lotto.randomPick())
                .toList();

        return new LottoTickets(lottoTickets);
    }
}
