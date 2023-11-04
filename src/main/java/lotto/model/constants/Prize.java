package lotto.model.constants;

public enum Prize {

    FIRST("6개 일치", 6, 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 5, 30_000_000),
    THIRD("5개 일치", 5, 1_500_000),
    FOURTH("4개 일치", 4, 50_000),
    FIFTH("3개 일치", 3, 5_000);

    private final String condition;
    private final int match;
    private final int money;

    Prize(final String condition, final int match, final int money) {
        this.condition = condition;
        this.match = match;
        this.money = money;
    }

    public static Prize findByMatch(final int match) {
        for (Prize prize : values()) {
            if (prize.match == match) {
                return prize;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getCondition() {
        return condition;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }
}
