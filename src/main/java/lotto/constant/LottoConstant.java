package lotto.constant;

public enum LottoConstant {
    NO_PRIZE(0, -1),
    FIRST_PLACE(6, 0),
    SECOND_PLACE(5, 1),
    THIRD_PLACE(5, 2),
    FOURTH_PLACE(4, 3),
    FIFTH_PLACE(3, 4);

    private final int value;
    private final int index;

    LottoConstant(int value, int index){
        this.value = value;
        this.index = index;
    }

    public int getValue(){
        return this.value;
    }
    public int getIndex() { return this.index; }
}
