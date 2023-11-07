package lotto;

import java.util.Arrays;

public enum LottoRanking {

    FIRST(6, 2_000_000_000), SECOND(5, 30_000_000), THIRD(5, 1_500_000),
    FOURTH(4, 50_000), FIFTH(3, 5_000), UNRANKED(0, 0);

    private final int correctNumber;
    private final int winningAmount;

    LottoRanking(int correctNumber, int winningAmount) {
        this.correctNumber = correctNumber;
        this.winningAmount = winningAmount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static LottoRanking getRanking(int correctNumber, boolean isBonusBallHit) {
        LottoRanking lottoRanking = getRanking(correctNumber);
        if (isNotSecondOrThird(lottoRanking)) {
            return lottoRanking;
        }
        return getRanking(isBonusBallHit);
    }

    private static LottoRanking getRanking(int correctNumber) {
        return Arrays.stream(LottoRanking.values())
            .filter(ranking -> ranking.correctNumber == correctNumber)
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
