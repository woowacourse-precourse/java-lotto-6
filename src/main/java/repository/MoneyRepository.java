package repository;

public class MoneyRepository {

    private int money = 0;
    private int trial = 0;

    public void save(int money) {
        this.money = money;
        this.trial = money/1000;
    }

    public int getMoney() {
        return money;
    }

    public int getTrial() {
        return trial;
    }
}
