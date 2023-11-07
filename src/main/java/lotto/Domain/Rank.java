package lotto.Domain;

public enum Rank {
    THREE_MATCH("3개 일치 (5,000원)"),
    FOUR_MATCH("4개 일치 (50,000원)"),
    FIVE_MATCH("5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH("6개 일치 (2,000,000,000원)"),
    NO_MATCH("꽝");

    private final String description;

    Rank(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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
}