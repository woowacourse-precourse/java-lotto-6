package Model;

public enum WinningRanks {
    FIRST_RANK(1),
    SECOND_RANK(2),
    THIRD_RANK(3),
    FOURTH_RANK(4),
    FIFTH_RANK(5);

    private final int value;

    WinningRanks(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
