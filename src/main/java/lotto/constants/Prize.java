package lotto.constants;

public enum Prize {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final Integer match;
    private final Integer payout;

    Prize(Integer match, Integer payout) {
        this.match = match;
        this.payout = payout;
    }

    public Integer getPayout() {
        return payout;
    }

    public Integer getMatch() {
        return match;
    }
}
