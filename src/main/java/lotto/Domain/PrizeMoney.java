package lotto.Domain;

public enum PrizeMoney {

    FIFTH(5000), FOURTH(50000), THIRD(1500000), SECOND(30000000), FIRST(2000000000);

    private final int value;
    PrizeMoney(int value) { this.value = value; }
    public int getValue() { return value; }
}
