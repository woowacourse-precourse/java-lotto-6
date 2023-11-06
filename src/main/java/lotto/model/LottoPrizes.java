package lotto.model;

public enum Lotto {
    FIRST_PRIZE(1),
    SECOND_PRIZE(2),
    THIRD_PRIZE(3),
    FOURTH_PRIZE(4),
    FIFTH_PRIZE(5);

    private final WinningResult result;

    WinningResult(WinningResult result) {
        this.result = result;
    }

    public WinningResult getResult() {
        return result;
    }
}
