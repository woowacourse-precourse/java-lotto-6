package lotto.model;

import lotto.util.LottoPrize;

public class Prize {
    private long money;

    public Prize() {
        this.money = 0;
    }

    public void addPrize(int grade) {
        this.money += LottoPrize.getPrize(grade);
    }

    public Long getMoney() {
        return this.money;
    }
}
