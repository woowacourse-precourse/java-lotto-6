package lotto.model;

import java.util.Arrays;

public enum LottoRanking {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    UNRANKED(0, 0);

    private final int hitCount;
    private final int winningAmount;

    LottoRanking(int hitCount, int winningAmount) {
        this.hitCount = hitCount;
        this.winningAmount = winningAmount;
    }

    public static LottoRanking getRanking(int hitCount, boolean isBonusBallHit) {
        LottoRanking lottoRanking = getRanking(hitCount);
        if (isNotSecondOrThird(lottoRanking)) {
            return lottoRanking;
        }
        return getRanking(isBonusBallHit);
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getHitCount() {
        return hitCount;
    }

    private static LottoRanking getRanking(int hitCount) {
        return Arrays.stream(LottoRanking.values())
            .filter(ranking -> ranking.hitCount == hitCount)
            .findAny()
            .orElse(UNRANKED);
    }

    private static boolean isNotSecondOrThird(LottoRanking lottoRanking) {
        if (lottoRanking != LottoRanking.SECOND && lottoRanking != LottoRanking.THIRD) {
            return true;
        }

        return false;
    }

    private static LottoRanking getRanking(boolean isBonusBallHit) {
        if (isBonusBallHit) {
            return LottoRanking.SECOND;
        }

        return LottoRanking.THIRD;
    }
}
