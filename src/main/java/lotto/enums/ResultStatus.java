package lotto.enums;

public enum ResultStatus {
    NONE0(0, false),
    NONE1(0, false),
    NONE2(0, false),
    MATCH3(5000, false),
    MATCH4(50000, false),
    MATCH5(1500000, false),
    MATCH5_WITH_BONUS_BALL(30000000, true),
    MATCH6(2000000000, false);

    private final int value;
    private final boolean hasBonusBall;

    ResultStatus(int value, boolean hasBonusBall) {
        this.value = value;
        this.hasBonusBall = hasBonusBall;
    }

    public int getValue() {
        return value;
    }

    public boolean getHasBonusBall() {
        return hasBonusBall;
    }
}
