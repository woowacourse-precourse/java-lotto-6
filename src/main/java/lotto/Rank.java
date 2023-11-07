package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int countOfMatch;
    private final boolean matchBonus;
    private final long winningMoney;

    Rank(int countOfMatch, boolean matchBonus, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.getCountOfMatch() == countOfMatch && rank.matchBonus == matchBonus)
                .findFirst()
                .orElse(MISS);
    }
}

