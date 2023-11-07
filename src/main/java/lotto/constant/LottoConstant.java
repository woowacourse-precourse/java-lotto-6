package lotto.constant;

public enum LottoConstant {
    NO_PRIZE_INDEX(-1),
    FIRST_PLACE_INDEX(0),
    SECOND_PLACE_INDEX(1),
    THIRD_PLACE_INDEX(2),
    FOURTH_PLACE_INDEX(3),
    FIFTH_PLACE_INDEX(4);

    private final int value;

    LottoConstant(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
