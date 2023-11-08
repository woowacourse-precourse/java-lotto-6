package lotto;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int winningNumber;
    private final boolean hasBonus;
    private final int prize;

    Ranking(int winningNumber, boolean hasBonus, int prize) {
        this.winningNumber = winningNumber;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Ranking findRanking(int winningNumber, boolean hasBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.winningNumber == winningNumber
                        && ranking.hasBonus == checkBonus(winningNumber, hasBonus))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static boolean checkBonus(int winningNumber, boolean hasBonus) {
        return winningNumber == 5 && hasBonus;
    }
}
