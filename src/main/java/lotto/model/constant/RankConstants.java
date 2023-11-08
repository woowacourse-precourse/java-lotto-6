package lotto.model.constant;

public enum RankConstants {
    RANK_FIRST(6),
    RANK_SECOND(5),
    RANK_FOURTH(4),
    RANK_FIFTH(3),
    RANK_INITIAL_VALUE(0),
    MATCHING_INCRESE_COUNT(1);

    private final int number;

    RankConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
