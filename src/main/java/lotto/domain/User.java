package lotto.domain;

import java.util.List;

public class User {
    private final Money buyAmount;
    private final LottoTicket lottoTicket;

    public User(Money buyAmount, LottoTicket lottoTicket) {
        this.buyAmount = buyAmount;
        this.lottoTicket = lottoTicket;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket.getLottoTicket();
    }

    public Money getBuyAmount() {
        return buyAmount;
    }
}