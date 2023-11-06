package lotto.domain;

public class User {

    private final int budget;
    private final LottoTickets lottoTickets;

    public User(final int budget, final LottoTickets lottoTickets) throws IllegalArgumentException {
        this.lottoTickets = lottoTickets;
        this.budget = budget;
    }

}
