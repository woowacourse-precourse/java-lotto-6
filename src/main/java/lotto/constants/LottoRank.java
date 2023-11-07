package lotto.constants;

import java.util.Arrays;

public enum LottoRank {
    FIFTH("3개",3, 5_000),
    FOURTH("4개", 4, 50_000),
    THIRD("5개", 5, 1_500_000),
    SECOND("5개 일치, 보너스 볼", 5, 30_000_000),
    FIRST("6개", 6, 2_000_000_000);

    private final String rewardName;
    private final int matchingCount;
    private final int reward;

    LottoRank(String rewardName, int matchingCount, int reward) {
        this.rewardName = rewardName;
        this.matchingCount = matchingCount;
        this.reward = reward;
    }

    public String getRewardName() {
        return rewardName;
    }

    public int getReward() {
        return reward;
    }

    public static int[] getRewardsAsArray() {
        return Arrays.stream(values())
                .mapToInt(LottoRank::getReward)
                .toArray();
    }
    public static String[] getRewardNamesAsArray() {
        return Arrays.stream(values())
                .map(LottoRank::getRewardName)
                .toArray(String[]::new);
    }
}
