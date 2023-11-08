package lotto.domain;

import java.util.Arrays;
import javax.swing.LookAndFeel;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank getRank(int countOfMatch, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .filter(rank -> !rank.equals(SECOND) || hasBonus)
                .findFirst()
                .orElse(MISS);
    }
}
