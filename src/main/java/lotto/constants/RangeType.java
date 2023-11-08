package lotto.constants;

public enum RangeType {
    PRIZE_NUMBER_MIN_RANGE(1),

    PRIZE_NUMBER_MAX_RANGE(45),

    PRIZE_NUMBER_SIZE(6),

    DIVISION_UNIT(1000);

    private final int range;

    RangeType(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
