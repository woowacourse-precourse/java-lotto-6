package lotto.model;

import java.util.List;
import lotto.util.Constants;

public class LottoTickets {
    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public int getSize() {
        return tickets.size();
    }

    protected List<Lotto> getTickets() {
        return tickets.stream().toList();
    }

    public LottoResult getResult(WinningNumber winningNumber) {
        List<Ranking> rankings = tickets.stream()
                .map(winningNumber::getRankings)
                .toList();
        return new LottoResult(rankings, tickets.size() * Constants.LOTTO_PRICE);
    }
}
