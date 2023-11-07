package lotto.constant;

public enum Rewards {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);
    
    private int value;

    private Rewards(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
