package lotto;

public enum LottoWinningStatus {
    FIRST_AWARD(6, 2_000_000_000),
    SECOND_AWARD_WITH_BONUS(5, 30_000_000),
    THIRD_AWARD(5, 1_500_000),
    FOURTH_AWARD(4, 50_000),
    FIFTH_AWARD(3, 5_000);

    private final int matchCount;
    private final int rewardMoney;

    LottoWinningStatus(int matchCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }
}
