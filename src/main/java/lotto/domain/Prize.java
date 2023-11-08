package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchedNumbers;
    private final boolean matchBonus;
    private final int prizeMoney;

    Prize(int matchedNumbers, boolean matchBonus, int prizeMoney) {
        this.matchedNumbers = matchedNumbers;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int matchedNumbers, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchedNumbers == matchedNumbers && prize.matchBonus == matchBonus)
                .findAny()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }
}
