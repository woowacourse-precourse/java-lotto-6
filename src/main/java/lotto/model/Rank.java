package lotto.model;

public enum Rank {
    MATCH_3(3, 5_000),
    MATCH_4(4, 50_000),
    MATCH_5(5,false,1_500_000),
    MATCH_5_BONUS(5,true,30_000_000),
    MATCH_6(6,2_000_000_000);
    private final int matchingNumbers;
    private final boolean bonusMatch;
    private final int prize;
    Rank(int matchingNumbers, int prize) {
        this(matchingNumbers, false, prize);
    }

    Rank(int matchingNumbers, boolean bonusMatch, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrize() {
        return prize;
    }
}
