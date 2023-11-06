package lotto.EnumList;

public enum ConstantNumber {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    FIVE_WIN_PRIZE(5000),
    FOUR_WIN_PRIZE(50000),
    THREE_WIN_PRIZE(1500000),
    TWO_WIN_PRIZE(30000000),
    FIRST_WIN_PRIZE(2000000000);

    private final int value;

    ConstantNumber(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
