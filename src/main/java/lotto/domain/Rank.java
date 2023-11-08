package lotto.domain;

import java.util.Arrays;
import lotto.constants.Config;

public enum Rank {
    FIRST(6, false, Config.FIRST_PRIZE_MONEY),
    SECOND(5, true, Config.SECOND_PRIZE_MONEY),
    THIRD(5, false, Config.THIRD_PRIZE_MONEY),
    FOURTH(4, false, Config.FOURTH_PRIZE_MONEY),
    FIFTH(3, false, Config.FIFTH_PRIZE_MONEY),
    MISS(0, false, Config.MISS_PRIZE_MONEY);

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

