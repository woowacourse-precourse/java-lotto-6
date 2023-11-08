package lotto.domain.reward.model;

public enum Reward {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int count;
    private final int reward;
    private final boolean isBonus;

    Reward(int count, int reward, boolean isBonus) {
        this.count = count;
        this.reward = reward;
        this.isBonus = isBonus;
    }

}
