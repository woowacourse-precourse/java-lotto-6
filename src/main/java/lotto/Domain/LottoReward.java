package lotto.Domain;

public enum LottoReward {

    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, true, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000),
    DEFAULT(0, 0);


    private final int equalCount;
    private final boolean equalBonusNumber;
    private final long reward;

    LottoReward(int equalCount, long reward) {
        this(equalCount, false, reward);
    }

    LottoReward(int equalCount, boolean equalBonusNumber, long reward) {
        this.equalCount = equalCount;
        this.equalBonusNumber = equalBonusNumber;
        this.reward = reward;
    }

    public static LottoReward getLottoReward(int equalCount, boolean equalBonusNumber) {
        for (LottoReward lottoReward : values()) {
            if (lottoReward.equalCount == equalCount && lottoReward.equalBonusNumber == equalBonusNumber) {
                return lottoReward;
            }
        }

        return DEFAULT;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public long getReward() {
        return reward;
    }
}
