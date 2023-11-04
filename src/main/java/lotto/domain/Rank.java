package lotto.domain;

public enum Rank {
    NO("0개 일치 - ",false,0),
    FIFTH("3개 일치 (5,000원) - ",false,3),
    FOURTH("4개 일치 (50,000원) - ",false,4),
    THIRD("5개 일치 (1,500,000원) - ",false,5),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ",true,5),
    FIRST("6개 일치 (2,000,000,000원) - ",false,6);
    private final String message;
    private final boolean bonusCheck;
    private final int matchCount;

    Rank(final String message, final boolean bonusCheck, final int matchCount) {
        this.message = message;
        this.bonusCheck = bonusCheck;
        this.matchCount = matchCount;
    }

    public String getMessage() {
        return message;
    }

    public boolean isBonusCheck() {
        return bonusCheck;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
