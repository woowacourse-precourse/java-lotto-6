package lotto.domain;

public enum Rank {
    MATCH_0(0, 0, false),
    MATCH_3(3, 5000, false),
    MATCH_4(4, 50000, false),
    MATCH_5(5, 1500000, false),
    MATCH_5_BONUS(5, 30000000, true),
    MATCH_6(6, 2000000000, false),

    /**
     * 3과 4의 경우 보너스 번호가 같더라도, 상품 금액은 동일 합니다.
     * 따라서 보너스 번호가 같은 경우도 정의 했습니다.
     */
    MATCH_3_BONUS(3, 5000, true),
    MATCH_4_BONUS(4, 50000, true),
    ;

    private final int matchCount;
    private final int winningAmount;
    private final boolean matchBonous;

    Rank(int matchCount, int winningAmount, boolean matchBonous) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.matchBonous = matchBonous;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public boolean isMatchBonous() {
        return matchBonous;
    }
}
