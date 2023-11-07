package domain;

import dto.LottoTickets;
import exception.NotPositiveLottoTicketsSizeException;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketsGeneratingMachine {
    private LottoTicketsGeneratingMachine() {

    }

    public static LottoTickets generateRandomLottoTickets(TicketSize ticketSize) {
        List<Lotto> lottoTickets = IntStream.range(0, ticketSize.getTicketSize())
                .mapToObj(cnt -> Lotto.randomPick())
                .toList();

        return new LottoTickets(lottoTickets);
    }
}
