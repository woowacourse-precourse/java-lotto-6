package lotto.domain;

import java.util.List;

public class User {
    public int payment;
    public final List<Lotto> lottos;

    public User(int payment) {
        this.payment = payment;
        this.lottos = Lotto.publish(payment);
    }
}
