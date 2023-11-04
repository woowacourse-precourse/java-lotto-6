package lotto.domain.config;

import lotto.domain.valueobject.FormattedNumber;

public enum RewardConfig {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000),
    NOTHING(0);

    private final int reward;

    RewardConfig(int reward) {
        this.reward = reward;
    }

    public FormattedNumber getRewardWithCommaSeparator() {
        return new FormattedNumber(reward);
    }
}
