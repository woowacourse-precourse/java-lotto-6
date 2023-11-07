package lotto.constant;

public enum LottoConstant {
    NO_PRIZE_INDEX(-1),
    FIRST_PLACE_MATCH_COUNT(6),
    SECOND_THIRD_PLACE_MATCH_COUNT(5),
    FOURTH_PLACE_MATCH_COUNT(4),
    FIFTH_PLACE_MATCH_COUNT(3);

    private final int value;

    LottoConstant(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
