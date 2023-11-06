package lotto;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Result {
    FIRST_PRIZE(6) {
        public int prize() {return 2_000_000_000;}},
    SECOND_PRIZE(5) {
        public int prize() {return 30_000_000;}},
    THIRD_PRIZE(5) {
        public int prize() {return 1_500_000;}},
    FOURTH_PRIZE(4) {
        public int prize() {return 50_000;}},
    FIFTH_PRIZE(3) {
        public int prize() {return 5_000;}},
    NO_PRIZE(2) {
        public int prize() {return 0;}};

    public abstract int prize();

    private final int matchingNumbers;

    Result(int matchingNumbers) {
        this.matchingNumbers = matchingNumbers;
    }

    public static Result from(int matchingNumbers, boolean bonus) {
        if (!bonus && (matchingNumbers == 5)) return THIRD_PRIZE;

        return Arrays.stream(values())
                .filter(result -> result.matchingNumbers == matchingNumbers)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }
}
