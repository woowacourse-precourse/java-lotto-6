package lotto.domain.answer.check;

public enum WinningPolicyCondition {
    FIRST(1, 6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(2, 5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(3, 5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 4, 50000, "4개 일치 (50,000원)"),
    FIFTH(5, 3, 5000, "3개 일치 (5,000원)");

    public final int rank;
    public final int matchCount;
    public final long winningPrice;
    public final String state;

    WinningPolicyCondition(int rank, int matchCount, long winningPrice, String state) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
        this.state = state;
    }
}
