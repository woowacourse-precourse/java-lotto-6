package domain;

import dto.LottoTickets;
import exception.NotPositiveLottoTicketsSizeException;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketsGeneratingMachine {
    public LottoTickets generateRandomLottoTickets(int ticketsSize) {
        validateTicketsSize(ticketsSize);
        List<Lotto> lottoTickets = IntStream.range(0, ticketsSize)
                .mapToObj(cnt -> Lotto.randomPick())
                .toList();

        return new LottoTickets(lottoTickets);
    }

    private void validateTicketsSize(int ticketsSize) {
        if (ticketsSize <= 0) {
            throw new NotPositiveLottoTicketsSizeException();
        }
    }
}
