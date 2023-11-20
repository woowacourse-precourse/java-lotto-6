package lotto.model;

public enum LottoPrize {
    FIRST_PRIZE(6, 2000000000, false),
    SECOND_PRIZE(5, 30000000, true),
    THIRD_PRIZE(5, 1500000, false),
    FOURTH_PRIZE(4, 50000, false),
    FIFTH_PRIZE(3, 5000, false);


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

    public boolean isBonus() {
        return bonus;
    }
}
