package lotto.domain;

public enum LottoResults {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L);

    private int correctCount;
    private long winningAmount;

    LottoResults(int correctCount, long winningAmount) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }
}
