package lotto;

public enum RankValue {
    RANK_NUMBER(6),
    FIRST_PLACE(1),
    SECOND_PLACE(2),
    THIRD_PLACE(3),
    FOURTH_PLACE(4),
    FIFTH_PLACE(5),
    LOSE(0),
    INIT_RANK_ARRAY(0);
    private final int rankValue;

    RankValue(int rankValue) {
        this.rankValue = rankValue;
    }

    public int getRankValue() {
        return this.rankValue;
    }
}
