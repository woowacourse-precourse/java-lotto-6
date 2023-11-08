package lotto.domain;

public enum WinningAmounts {
    FIRST_AMOUNT(2000000000, 0,7),
    SECOND_AMOUNT(30000000,0,6),
    THIRD_AMOUNT(1500000,0,5),
    FORTH_AMOUNT(50000,0,4),
    FIFTH_AMOUNT(5000,0,3),
    NO_AMOUNT(0,0,0);

    private final int value;
    public int count;
    public final int score;
    WinningAmounts(int value, int count, int score){
        this.value = value;
        this.count = count;
        this.score = score;
    }

    public int getValue(){
        return value;
    }

    public int getCount(){
        return count;
    }
    public int getPrize(){
        return value * count;
    }
}