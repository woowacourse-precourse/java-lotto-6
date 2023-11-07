package lotto.constant;

public enum Ranking {
    MATCH_THREE(1),
    MATCH_FOUR(2),
    MATCH_FIVE(3),
    MATCH_BONUS(4),
    MATCH_SIX(5);

    private final int value;
    Ranking(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
