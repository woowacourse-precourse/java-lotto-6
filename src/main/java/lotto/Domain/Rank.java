package lotto.Domain;

public enum Rank {
    THREE_MATCH("3개 일치 (5,000원)", 5000),
    FOUR_MATCH("4개 일치 (50,000원)", 50000),
    FIVE_MATCH("5개 일치 (1,500,000원)", 1500000),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX_MATCH("6개 일치 (2,000,000,000원)", 2000000000),
    NO_MATCH("꽝", 0);

    private final String description;
    private final int prize; // 상금(금액)

    Rank(String description, int prize) {
        this.description = description;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }

    public static String getResultDescription(int matchingNumbers, boolean bonusNumberMatch) {
        for (Rank rank : Rank.values()) {
            if (matchingNumbers == rank.getMatchingNumbers() && bonusNumberMatch == rank.isBonusNumberMatch()) {
                return rank.getDescription();
            }
        }
        return "꽝";
    }

    public int getMatchingNumbers() {
        int length = description.indexOf("개");
        return Integer.parseInt(description.substring(0, length));
    }

    public boolean isBonusNumberMatch() {
        return description.contains("보너스 볼");
    }

    public static Rank matchingNumbersToRank(int matchingNumbers, boolean bonusNumberMatch) {
        if (matchingNumbers == 6) { return Rank.SIX_MATCH; }
        if (matchingNumbers == 5 && bonusNumberMatch) { return Rank.FIVE_MATCH_WITH_BONUS; }
        if (matchingNumbers == 5) { return Rank.FIVE_MATCH; }
        if (matchingNumbers == 4) { return Rank.FOUR_MATCH; }
        if (matchingNumbers == 3) { return Rank.THREE_MATCH; }
        return Rank.NO_MATCH;
    }
}
