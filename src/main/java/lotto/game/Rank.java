package lotto.game;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    final int count;
    final int reward;
    final boolean bonus;

    Rank(int count, boolean bonus, int reward) {
        this.count = count;
        this.reward = reward;
        this.bonus = bonus;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isBonus() {
        return this.bonus;
    }

    public int getReward() {
        return this.reward;
    }
}
