package lotto.validator.constants;

public enum RangeType {

    PRIZE_NUMBER_MIN_RANGE(0),
    PRIZE_NUMBER_MAX_RANGE(45);
    private final int range;

    RangeType(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
