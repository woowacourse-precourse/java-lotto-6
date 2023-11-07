package lotto.domain;

import java.util.List;

public class Customer {
    private final Money money;
    private final Lottos lottos;

    public Customer(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }


    public Money getMoney() {
        return money;
    }
}
