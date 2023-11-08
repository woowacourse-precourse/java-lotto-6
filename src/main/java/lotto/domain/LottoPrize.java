package lotto.domain;

public enum LottoPrize {
    THREE_MATCH(3, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchedNumbers;
    private final int prizeMoney;
    private final String message;

    LottoPrize(int matchedNumbers, int prizeMoney, String message) {
        this.matchedNumbers = matchedNumbers;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
