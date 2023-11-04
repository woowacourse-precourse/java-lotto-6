package lotto.model;

public class Human {
    private final int count;
    private final int money;

    public Human(int money) {
        this.money = money;
        this.count = money % 1000;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }
}
