package lotto.domain;

public class User {
    private final Money money;
    private final LottoTicket lottoTicket;

    public User(Money money, LottoTicket lottoTicket) {
        this.money = money;
        this.lottoTicket = lottoTicket;
    }

    public void spendAllMoney() {
        money.zero();
    }
}