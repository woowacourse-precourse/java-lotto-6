package lotto;

public enum Rank {
    FIRST(6, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, "5개 일치 (1,500,000원)"),
    FOURTH(4, "4개 일치 (50,000원)"),
    FIFTH(3, "3개 일치 (5,000원)");

    private int matchedNumbers;
    private boolean bonusMatch;
    private String description;

    Rank(int matchedNumbers, String description) {
        this.matchedNumbers = matchedNumbers;
        this.bonusMatch = false;
        this.description = description;
    }

    Rank(int matchedNumbers, boolean bonusMatch, String description) {
        this.matchedNumbers = matchedNumbers;
        this.bonusMatch = bonusMatch;
        this.description = description;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public String getDescription() {
        return description;
    }
}
