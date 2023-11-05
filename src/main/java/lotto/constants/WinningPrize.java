package lotto.constants;

public enum WinningPrize {
    FIRST_PLACE_RETURN(2000000000),
    SECOND_PLACE_RETURN(30000000),
    THIRD_PLACE_RETURN(1500000),
    FORTH_PLACE_RETURN(50000),
    FIFTH_PLACE_RETURN(5000);

    private final int value;

    WinningPrize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
