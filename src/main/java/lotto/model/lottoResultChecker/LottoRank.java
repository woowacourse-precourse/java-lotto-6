package lotto.model.lottoResultChecker;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int winningMoney;

    LottoRank(int matchCount, boolean matchBonus, int winningMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public boolean matches(int count, boolean bonus) {
        if (this == SECOND) {
            return matchCount == count && matchBonus == bonus;
        }
        return matchCount == count;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchCount, matchBonus))
                .findFirst()
                .orElse(NONE);
    }
}