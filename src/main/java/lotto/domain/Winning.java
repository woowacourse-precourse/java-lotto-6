package lotto.domain;

public enum Winning {

    FIRST("6개 일치", 6, false, 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 5, true, 30_000_000),
    THIRD("5개 일치", 5, false, 1_500_000),
    FOURTH("4개 일치", 4, false, 50_000),
    FIFTH("3개 일치", 3, false, 5_000);

    private final String condition;
    private final int match;
    private final boolean bonus;
    private final int reward;

    Winning(final String condition, final int match, final boolean bonus, final int reward) {
        this.condition = condition;
        this.match = match;
        this.bonus = bonus;
        this.reward = reward;
    }

    public String getCondition() {
        return condition;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return reward;
    }
}