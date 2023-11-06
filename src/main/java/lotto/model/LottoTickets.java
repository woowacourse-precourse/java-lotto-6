package lotto.model;

import java.util.List;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public String toOutputString() {
        final String deli = "\n";
        final StringBuilder builder = new StringBuilder();

        for (final Lotto ticket : tickets) {
            builder.append(ticket.numbersToString());
            builder.append(deli);
        }

        return builder.toString();
    }

    public int getTicketsCount() {
        return tickets.size();
    }

    public LottoResult getLottoResult(LottoChecker lottoChecker) {
        final LottoResult result = new LottoResult();
        for (final Lotto ticket : tickets) {
            final LottoRank lottoRank = lottoChecker.checkTicket(ticket);
            result.increaseRankCount(lottoRank);
        }
        return result;
    }

}