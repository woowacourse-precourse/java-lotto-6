package lotto.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    OTHER(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int count;
    private final boolean bonus;
    private final int prizeMoney;

    Rank(int count, boolean bonus, int prizeMoney) {
        this.count = count;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
    }

    public static Rank calculateRank(int count, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (rank.count == count && rank.bonus == bonus) {
                return rank;
            }
        }
        return OTHER;
    }

    public static boolean isThirdCount(int count) {
        return count == THIRD.count;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static List<Rank> getRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != OTHER)
                .toList();
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }
}