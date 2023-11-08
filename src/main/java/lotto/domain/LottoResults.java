package lotto.domain;

public enum LottoResults {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    FAIL(0, 0L);

    private final int correctCount;
    private final long winningAmount;

    LottoResults(int correctCount, long winningAmount) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }

    public static LottoResults getLottoResult(int correctCount, boolean hasBonus) {
        if (isThird(correctCount, hasBonus)) {
            return LottoResults.THIRD;
        }

        for (LottoResults lottoResults : LottoResults.values()) {
            if (lottoResults.correctCount == correctCount) {
                return lottoResults;
            }
        }

        return LottoResults.FAIL;
    }

    public long getWinningAmount() {
        return this.winningAmount;
    }

    private static boolean isThird(int correctCount, boolean hasBonus) {
        return correctCount == LottoResults.THIRD.correctCount && !hasBonus;
    }
}
