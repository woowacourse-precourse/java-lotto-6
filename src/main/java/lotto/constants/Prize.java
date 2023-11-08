package lotto.constants;

public enum Prize {
    ZERO(0, 0L),
    ONE(1, 0L),
    TWO(2, 0L),
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    BONUS(5, 30000000L),
    SIX(6, 2000000000L);

    private final Integer match;
    private final Long payout;

    Prize(Integer match, Long payout) {
        this.match = match;
        this.payout = payout;
    }

    public Long getPayout() {
        return payout;
    }

    public Integer getMatch() {
        return match;
    }
}
