package lotto.domain.answer.check;

public enum WinningPolicyCondition {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    final int rank;
    final int matchCount;
    final int winningPrice;

    WinningPolicyCondition(int rank, int matchCount, int winningPrice) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }
}
