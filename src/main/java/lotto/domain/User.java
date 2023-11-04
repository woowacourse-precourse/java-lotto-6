package lotto.domain;

import java.util.List;

public class User {
    private List<Lotto> lotties;
    private int payment;

    public User(List<Lotto> lotties, int payment) {
        this.lotties = lotties;
        this.payment = payment;
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    public int getPayment() {
        return payment;
    }
}
