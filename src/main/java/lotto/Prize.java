package lotto;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int match;
    private final int profit;
    private final boolean withBonus;

    Prize(int match, int profit) {
        this(match, profit, false);
    }

    Prize(int match, int profit, boolean withBonus) {
        this.match = match;
        this.profit = profit;
        this.withBonus = withBonus;
    }


    public int getMatch() {
        return match;
    }

    public boolean gotPrize() {
        return profit != 0;
    }

    public int getProfit() {
        return profit;
    }

    public boolean isWithBonus() {
        return withBonus;
    }

    public static Prize findPrizeByMatch(int match, boolean withBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> isRank(prize, match, withBonus))
                .findFirst()
                .orElse(Prize.NONE);
    }


    private static boolean isRank(Prize prize, int match, boolean withBonus) {
        return prize.match == match &&
                prize.withBonus == withBonus;
    }

}

