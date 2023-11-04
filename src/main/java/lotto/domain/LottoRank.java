package lotto.domain;

public enum LottoRank {
    OUT_RANK(0),
    THREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    FIVE_AND_BONUS_MATCH(30000000),
    SIX_MATCH(2000000000);

    private final int prizeMoney;

    LottoRank(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
