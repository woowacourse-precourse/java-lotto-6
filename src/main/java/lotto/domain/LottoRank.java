package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    FAIL(0, false, 0);

    private int matchCount;
    private boolean bonusBall;
    private int reward;

    private LottoRank(int matchCount, boolean bonusBall, int reward) {
        this.matchCount = matchCount;
        this.bonusBall = bonusBall;
        this.reward = reward;
    }

    public static LottoRank findLottoRank(int count, boolean containBonusBall) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> isSameMatchCount(rank, count))
                .filter(rank -> checkBonusBall(rank, containBonusBall))
                .findAny()
                .orElse(FAIL);
    }

    private static boolean isSameMatchCount(LottoRank rank, int count) {
        return rank.matchCount == count;
    }

    private static boolean checkBonusBall(LottoRank rank, boolean containBonusBall) {
        return rank.bonusBall == containBonusBall;
    }

    public int calculateReward(int count) {
        return count * reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusBall() {
        return bonusBall;
    }

    public int getReward() {
        return reward;
    }

    public String getFormattedReward() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(reward);
    }
}
