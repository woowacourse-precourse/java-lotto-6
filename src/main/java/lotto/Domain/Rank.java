package lotto.Domain;

public enum Rank {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    LOSE(0, 0, false);

    private int prizeAmount;
    private int matchedNumbers;
    private boolean containBonusNum;

    Rank(int prizeAmount, int matchedNumbers, boolean containBonusNum) {
        this.prizeAmount = prizeAmount;
        this.matchedNumbers = matchedNumbers;
        this.containBonusNum = containBonusNum;
    }

    public static Rank getRank(int sameNumbers, boolean isBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchedNumbers() == sameNumbers && rank.isContainBonusNum() == isBonus) {
                return rank;
            }
        }
        return LOSE;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public boolean isContainBonusNum() {
        return containBonusNum;
    }
}
