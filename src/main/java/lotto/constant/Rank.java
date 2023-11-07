package lotto.constant;

public enum Rank {
    FIRST_PLACE("6개 일치", 2000000000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 30000000),
    THIRD_PLACE("5개 일치", 1500000),
    FOURTH_PLACE("4개 일치", 50000),
    FIFTH_PLACE("3개 일치", 5000);

    private String standard;
    private int money;

    Rank(String standard, int money) {
        this.standard = standard;
        this.money = money;
    }

    public String getStandard() {
        return standard;
    }

    public int getMoney() {
        return money;
    }
}
