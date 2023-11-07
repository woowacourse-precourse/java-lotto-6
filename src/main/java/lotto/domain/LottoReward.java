package lotto.domain;

import static lotto.constants.DomainConstants.SECOND_STANDARD;

public enum LottoReward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private Integer matchCount;
    private Integer reward;

    LottoReward(Integer matchCount, Integer reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoReward getReward(Integer correctNumbers, Boolean isCorrectBonusNumber) {
        for (LottoReward reward : values()) {
            if (correctNumbers.equals(SECOND_STANDARD) && isCorrectBonusNumber) {
                return SECOND;
            }

            if (correctNumbers.equals(SECOND_STANDARD) && !isCorrectBonusNumber) {
                return THIRD;
            }

            if (reward.matchCount.equals(correctNumbers)) {
                return reward;
            }
        }
        return NOTHING;
    }

    public Integer getReward() {
        return reward;
    }
}
