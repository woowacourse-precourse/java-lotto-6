package lotto.domain;

public enum LottoPrize {
    matchZero(0, 0, false),
    matchThree(3, 5000, false),
    matchFour(4,50000, false),
    matchFive(5, 1500000, false),
    matchFiveBonus(5, 30000000, true),
    matchSix(6, 2000000000, false);

    private final int matchedNumbers;
    private final int prize;
    private final boolean bonus;

    LottoPrize(int matchedNumbers, int prize, boolean bonus) {
        this.matchedNumbers = matchedNumbers;
        this.prize = prize;
        this.bonus = bonus;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public int getPrize() {
        return prize;
    }

    public boolean matchedBonus() {
        return bonus;
    }
}

