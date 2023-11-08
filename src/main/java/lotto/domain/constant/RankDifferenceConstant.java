package lotto.domain.constant;

public enum RankDifferenceConstant {
    FIRST_RANK_DIFFERENCE_FROM_WINNING(0),
    SECOND_RANK_DIFFERENCE_FROM_WINNING(1),
    THIRD_RANK_DIFFERENCE_FROM_WINNING(1),
    FOURTH_RANK_DIFFERENCE_FROM_WINNING(2),
    FIFTH_RANK_DIFFERENCE_FROM_WINNING(3);

    private final int difference;

    RankDifferenceConstant(final int difference) {
        this.difference = difference;
    }

    public int getDifference() {
        return this.difference;
    }
}