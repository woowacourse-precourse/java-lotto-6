package lotto;

public enum Prize {

    FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000), OTHER(0);

    private final int value;

    Prize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
