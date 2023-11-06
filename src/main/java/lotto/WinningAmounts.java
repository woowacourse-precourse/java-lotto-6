package lotto;

public enum WinningAmounts {
    FIRST_AMOUNT(2000000000),
    SECOND_AMOUNT(30000000),
    THIRD_AMOUNT(1500000),
    FORTH_AMOUNT(50000),
    FIFTH_AMOUNT(3000),
    NO_AMOUNT(0);

    private final int value;
    WinningAmounts(int value){this.value = value;}
    public int getValue(){return value;}
}
