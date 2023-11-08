package consts;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank of(int matchCount, boolean isBonusMatched) {
        if (matchCount == SECOND.matchCount && isBonusMatched) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static List<Rank> getRanks() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
