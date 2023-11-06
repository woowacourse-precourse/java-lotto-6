package lotto.domain;

public class User {

    private final int budget;
    private LottoTickets lottoTickets;

    public User(final int budget) throws IllegalArgumentException {
        this.budget = budget;
    }

}
