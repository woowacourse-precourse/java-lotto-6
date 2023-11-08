package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    NONE(0, 0, "");

    private final int matchCount;
    private final int winningMoney;
    private final String message;

    Rank(int matchCount, int winningMoney, String message) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Rank valueOf(int matchCount, boolean isMatchBonus) {
        if (matchCount == 5 && isMatchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        if (matchCount == 6) {
            return FIRST;
        }
        return NONE;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
