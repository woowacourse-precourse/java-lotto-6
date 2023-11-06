package lotto;

public enum Result {
    FIRST_PRIZE(6, false) {int prize() {return 2_000_000_000;}},
    SECOND_PRIZE(5, true) {int prize() {return 30_000_000;}},
    THIRD_PRIZE(5, false) {int prize() {return 1_500_000;}},
    FOURTH_PRIZE(4, false) {int prize() {return 50_000;}},
    FIFTH_PRIZE(3, false) {int prize() {return 5_000;}},
    NO_PRIZE(0, false) {int prize() {return 0;}};

    abstract int prize();
    private final int matchingNumbers;
    private final boolean bonus;

    Result(int matchingNumbers, boolean bonus) {
        this.matchingNumbers = matchingNumbers;
        this.bonus = bonus;
    }
}
