package lotto.model;

import static lotto.model.SystemConstant.NUM_OF_NUMBERS;

public enum Rank {
    FIFTH(NUM_OF_NUMBERS - 3, 5000, false),
    FOURTH(NUM_OF_NUMBERS - 2, 50000, false),
    THIRD(NUM_OF_NUMBERS - 1, 1500000, false),
    SECOND(NUM_OF_NUMBERS - 1, 30000000, true),
    FIRST(NUM_OF_NUMBERS, 2000000000, false);

    private final int matchingNumbers;
    private final int prizeMoney;
    private final boolean bonus;

    Rank(int matchingNumbers, int prizeMoney, boolean bonus) {
        this.matchingNumbers = matchingNumbers;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonus() {
        return bonus;
    }
}
