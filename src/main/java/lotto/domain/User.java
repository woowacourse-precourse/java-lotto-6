package lotto.domain;

import java.util.List;

public class User {

    private List<Lotto> lottoTickets;
    private int payment;

    public User(int payment, List<Lotto> lottoTickets) {
        this.payment = payment;
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getPayment() {
        return payment;
    }

}
