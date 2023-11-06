package lotto.common.constants;

public enum LottoRankRule {
    FIRST_RANK_MATCH_COUNT(6),
    SECOND_RANK_MATCH_COUNT(5),
    THIRD_RANK_MATCH_COUNT(5),
    FOURTH_RANK_MATCH_COUNT(4),
    FIFTH_RANK_MATCH_COUNT(3),

    FIRST_RANK_PRICE(2000000000),
    SECOND_RANK_PRICE(30000000),
    THIRD_RANK_PRICE(1500000),
    FOURTH_RANK_PRICE(50000),
    FIFTH_RANK_PRICE(5000);

    private final int rank;

    LottoRankRule(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
