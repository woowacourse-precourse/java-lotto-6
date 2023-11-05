package lotto.model;

import java.util.Arrays;

public enum Rank {
    SIX(6, 2000000000),
    FIVE_BONUS(7, 30000000),
    FIVE(5, 1500000),
    FOUR(4, 50000),
    THREE(3, 5000),
    ECT(0, 0);

    private final int matchingNumber;
    private final int prize;

    Rank(int matchingNumber, int prize) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
    }

    public static Rank getPrize(int number) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchingNumber == number)
                .findAny()
                .orElse(ECT);
    }

}
