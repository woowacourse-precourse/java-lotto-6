package lotto.enums;

import java.util.Arrays;

public enum Prize {
    NONE(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final int prize;
    private final int winCount;
    private final boolean isSecond;

    Prize(int prize, int winCount, boolean isSecond) {
        this.prize = prize;
        this.winCount = winCount;
        this.isSecond = isSecond;
    }

    public static int getPrize(int winCount, boolean isSecond) {
        return Arrays.stream(values())
                .filter(prize -> prize.winCount == winCount)
                .filter(prize -> prize.isSecond == isSecond)
                .findAny()
                .orElse(NONE)
                .getPrize();
    }

    public int getPrize() {
        return this.prize;
    }
}
