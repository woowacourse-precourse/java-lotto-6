package lotto.model;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchNum;
    private final boolean matchBonus;
    private final int prizeMoney;

    Prize(int matchNum, boolean matchBonus, int prizeMoney) {
        this.matchNum = matchNum;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getRank(int number, boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(o -> o.matchNum == number
                        && o.matchBonus == bonusNumber)
                .findAny()
                .orElse(MISS);
    }

    public int getMatchNum() {
        return matchNum;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
