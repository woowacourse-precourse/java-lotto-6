package lotto.domain;

public enum Prize {
    THREE_MATCH(3, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, "6개 일치 (2,000,000,000원)");

    private final int matchingNumbers;
    private final String prizeName;

    Prize(int matchingNumbers, String prizeName) {
        this.matchingNumbers = matchingNumbers;
        this.prizeName = prizeName;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public String getPrizeName() {
        return prizeName;
    }
}
