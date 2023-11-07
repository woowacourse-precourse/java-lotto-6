package lotto.model;

import java.util.List;

public class User {
    private final int count;
    private final LottoTickets lottoTickets;

    public User(int count, LottoTickets lottoTickets) {
        this.count = count;
        this.lottoTickets = lottoTickets;
    }

    public int getCount() {
        return count;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public List<Lotto> getLottoList() {
        return lottoTickets.getLotto();
    }
}
