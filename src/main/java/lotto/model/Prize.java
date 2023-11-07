package lotto.model;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchedNumber;
    private final boolean matchedBonus;
    private final int winningMoney;

    Prize(int matchedNumber, boolean matchedBonus, int winningMoney) {
        this.matchedNumber = matchedNumber;
        this.matchedBonus = matchedBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatchedNumbers() {
        return matchedNumber;
    }

    public boolean isMatchedBonus() {
        return matchedBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Prize getRank(int matchedNumber, boolean matchedBonus) {
        return Arrays.stream(values())
                .filter(o -> o.matchedNumber == matchedNumber
                        && o.matchedBonus == matchedBonus)
                .findAny()
                .orElse(MISS);
    }
}
