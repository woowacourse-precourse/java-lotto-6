package lotto;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Result {
    NO_PRIZE(2, 0),
    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private final int matchingNumbers;
    private final long prize;

    Result(int matchingNumbers, long prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public static Result from(int matchingNumbers, boolean bonus) {
        if (bonus && (matchingNumbers == 5)) return SECOND_PRIZE;
        if (!bonus && (matchingNumbers == 5)) return THIRD_PRIZE;

        return Arrays.stream(values())
                .filter(result -> result.matchingNumbers == matchingNumbers)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public long getPrize() {
        return prize;
    }
}
