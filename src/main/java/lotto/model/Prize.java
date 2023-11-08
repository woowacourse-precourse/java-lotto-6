package lotto.model;

public enum Prize {
    MATCH_3(3, 5000,true),
    MATCH_4(4, 50000,true),
    MATCH_5(5, 1500000,true),
    MATCH_5_WITH_BONUS(5, 30000000, false),
    MATCH_6(6, 2000000000,true);

    private final int matchingNumbers;
    private final int prizeAmount;
    private final boolean hasBonus;

    Prize(int matchingNumbers, int prizeAmount, boolean hasBonus) {
        this.matchingNumbers = matchingNumbers;
        this.prizeAmount = prizeAmount;
        this.hasBonus = hasBonus;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }
}
