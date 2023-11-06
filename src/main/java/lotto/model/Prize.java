package lotto.model;

public class Prize {
    private long money;

    protected Prize() {
        this.money = 0;
    }

    protected void addPrize(long money) {
        this.money += money;
    }

    protected double getMoney() {
        return this.money;
    }
}
