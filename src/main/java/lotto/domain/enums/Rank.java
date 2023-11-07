package lotto.domain.enums;

public enum Rank {
    MISS(0, 0, "0개 일치 - "),
    FIFTH(5_000, 3,  "3개 일치 - "),
    FOURTH(50_000, 4, "4개 일치 - "),
    THIRD(1_500_000, 3, "5개 일치 - "),
    SECOND(30_000_000, 2, "5개 일치, 보너스 볼 일치 - "),
    FIRST(2_000_000_000, 1, "6개 일치 - ");

    private int matchCount;
    private int winningAmount;
    private String message;

    Rank(int matchCount, int winningAmount, String message) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.message = message;
    }
}
