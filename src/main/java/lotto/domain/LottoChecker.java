package lotto.domain;

import java.util.List;

public class LottoChecker {
    private final List<Ticket> tickets;
    private final DrawResult drawResult;
    public LottoChecker(List<Ticket> tickets, DrawResult drawResult) {
        this.tickets = tickets;
        this.drawResult = drawResult;
    }

    private LottoResult checkOneTicket(Ticket ticket) {
        int matchNumbers = drawResult.getMatchNumbers(ticket);
        boolean isBonusMatch = drawResult.isBonusMatch(ticket);
        return new LottoResult(matchNumbers, isBonusMatch);
    }

    public List<LottoResult> checkTickets() {
        return tickets.stream()
                .map(this::checkOneTicket)
                .toList();
    }
}
