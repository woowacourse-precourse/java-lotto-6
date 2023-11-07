package lotto.constant;

public enum LottoConstant {
    NO_PRIZE(0, -1, 0),
    FIRST_PLACE(6, 0, 2000000000),
    SECOND_PLACE(5, 1, 30000000),
    THIRD_PLACE(5, 2, 1500000),
    FOURTH_PLACE(4, 3, 50000),
    FIFTH_PLACE(3, 4, 5000);

    private final int value;
    private final int index;
    private final int prize;

    LottoConstant(int value, int index, int prize){
        this.value = value;
        this.index = index;
        this.prize = prize;
    }

    public int getValue(){
        return this.value;
    }
    public int getIndex() { return this.index; }
    public int getPrize() { return this.prize; }
}
