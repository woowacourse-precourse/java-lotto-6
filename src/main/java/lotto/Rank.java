package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NORANK(0, 0),
    ;

    private final int correctNumberCnt;
    private final int rewardMoney;

    Rank(int correctNumberCnt, int rewardMoney) {
        this.correctNumberCnt = correctNumberCnt;
        this.rewardMoney = rewardMoney;
    }

    public int getCorrectNumberCnt() {
        return correctNumberCnt;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static Rank findRank(int matchNumberCnt, boolean isBonus) {
        if (SECOND.correctNumberCnt == matchNumberCnt && isBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.find(matchNumberCnt) && rank != SECOND)
                .findAny()
                .orElse(NORANK);
    }

    private boolean find(int count) {
        return this.correctNumberCnt == count;
    }

}
