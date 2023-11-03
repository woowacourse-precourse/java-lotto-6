package lotto.domain;

public class User {
    private Lotties lotties;
    private int payment;

    public User(Lotties lotties, int payment) {
        this.lotties = lotties;
        this.payment = payment;
    }

    public Lotties getLottiesImpl() {
        return lotties;
    }

    public int getPayment() {
        return payment;
    }
}
