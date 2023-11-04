package lotto.model;

import java.util.List;

public class Customer {
    private List<Lotto> lottos;
    private Money budget;
    public Customer(Money budget) {
        this.budget = budget;
    }
    public int getLottoCount() {
        return budget.getMoney() / 1000;
    }
}
