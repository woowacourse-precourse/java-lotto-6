package lotto.config;

import java.util.Arrays;

public enum WinningPrize {
    FIFTH_PLACE(3, "3개 일치", 5000),
    FOURTH_PLACE(4, "4개 일치", 50000),
    THIRD_PLACE(5, "5개 일치", 1500000),
    SECOND_PLACE(-1, "5개 일치, 보너스 볼 일치", 30000000),
    FIRST_PLACE(6, "6개 일치", 2000000000);

    private final int match;
    private final String message;
    private final int prize;

    WinningPrize(int match, String message, int prize) {
        this.match = match;
        this.message = message;
        this.prize = prize;
    }

    public static WinningPrize getPrizeWithMatch(int match) {
        return Arrays.stream(values())
                .filter(it -> it.match == match)
                .findAny()
                .orElse(null);
    }

    public int match() {
        return match;
    }

    public String message() {
        return message;
    }

    public int prize() {
        return prize;
    }
}
