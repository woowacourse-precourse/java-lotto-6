package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int count;
    private final int winningAmount;

    Rank(int count, int winningAmount) {
        this.count = count;
        this.winningAmount = winningAmount;
    }

    public static Rank getRank(int count, boolean hasBonusNumber) {
        Rank rank = Arrays.stream(values())
                .filter(r -> r.count == count)
                .findFirst()
                .orElse(null);

        if (rank == SECOND && !hasBonusNumber) {
            rank = THIRD;
        }

        return rank;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}