package lotto.domain;

public enum Prize {

    NONE(0, 0, " "),
    THREE_MATCH(3, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS_MATCH(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matches;
    private final int prizeAmount;
    private final String description;


    Prize(int matches, int prizeAmount, String description) {
        this.matches = matches;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public int getMatches() {
        return matches;
    }
    public int getPrizeAmount() {
        return prizeAmount;
    }
    public String getDescription() {
        return description;
    }

    public static Prize findMatchingPrize(int match, boolean hasBonus) {
        if (match < 3) {
            return Prize.NONE;
        }
        if (match == 5) {
            return BonusOrNot(hasBonus);
        }
        return findPrizeForRegularMatch(match);
    }

    public static Prize findPrizeForRegularMatch(int match) {
        for (Prize prize : Prize.values()) {
            if (isMatchCountEqual(prize, match)) {
                return prize;
            }
        }
        return NONE;
    }

    public static boolean isMatchCountEqual(Prize prize, int matches) {
        return prize.matches == matches;
    }

    public static Prize BonusOrNot(boolean hasBonus) {
        if (hasBonus) {
            return FIVE_BONUS_MATCH;
        }
        return FIVE_MATCH;
    }
}