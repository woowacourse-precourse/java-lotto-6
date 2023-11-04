package lotto.model;

public enum Prize {

    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000);

    private final String condition;
    private final int money;

    Prize(final String condition, final int money) {
        this.condition = condition;
        this.money = money;
    }

    public String getCondition() {
        return condition;
    }

    public int getMoney() {
        return money;
    }
}
