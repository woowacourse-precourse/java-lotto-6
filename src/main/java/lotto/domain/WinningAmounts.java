package lotto.domain;

public enum WinningAmounts {
    FIRST_AMOUNT(2000000000, 0),
    SECOND_AMOUNT(30000000,0),
    THIRD_AMOUNT(1500000,0),
    FORTH_AMOUNT(50000,0),
    FIFTH_AMOUNT(3000,0),
    NO_AMOUNT(0,0);

    private final int value;
    public int count;
    WinningAmounts(int value, int count){
        this.value = value;
        this.count = count;
    }
    public int getValue(){
        return value;
        // return count;
    }
}
