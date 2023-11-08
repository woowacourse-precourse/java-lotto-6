package lotto;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    BLANK(0, false, 0L);

    private final int winningNumber;
    private final boolean hasBonus;
    private final long prize;

    Ranking(int winningNumber, boolean hasBonus, long prize) {
        this.winningNumber = winningNumber;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Ranking findRanking(int winningNumber, boolean hasBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.winningNumber == winningNumber
                        && ranking.hasBonus == checkBonus(winningNumber, hasBonus))
                .findAny()
                .orElse(BLANK);
    }

    private static boolean checkBonus(int winningNumber, boolean hasBonus) {
        return winningNumber == 5 && hasBonus;
    }

    public long getPrize() {
        return prize;
    }
}
