package lotto.model;

import lotto.Lotto;

import java.util.List;

public class Customer {
    private final int money;
    private List<Lotto> lottos;
    public Customer(int _money) {
        this.money = _money;
    }
    public int getMoney() {
        return money;
    }
}
