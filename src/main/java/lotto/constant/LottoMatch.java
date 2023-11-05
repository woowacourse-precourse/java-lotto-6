package lotto.constant;

public enum LottoMatch {
    SIX_MATCH(6, "6개 일치"),
    FIVE_MATCH(5, "5개 일치"),
    FIVE_MATCH_WITH_BONUS(5, "5개 일치, 보너스 번호 일치"),
    FOUR_MATCH(4, "4개 일치"),
    THREE_MATCH(3, "3개 일치"),
    TWO_MATCH(2, "2개 일치"),
    ONE_MATCH(1, "1개 일치"),
    NO_MATCH(0, "0개 일치")
    ;

    private final int matchCount;
    private final String description;

    LottoMatch(int matchCount, String description) {
        this.matchCount = matchCount;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }
}
