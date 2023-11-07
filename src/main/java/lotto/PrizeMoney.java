package lotto;

public enum PrizeMoney {
    NONE(0),
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);

    private final int value;

    PrizeMoney(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
