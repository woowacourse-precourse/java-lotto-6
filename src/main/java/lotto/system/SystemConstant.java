package lotto.system;

public enum SystemConstant {
    LOTTO_TICKET_PRICE(1000),
    LOTTO_RANK_COUNT(LottoRankConstant.values().length),
    WINNING_STATS_START(1),
    WINNING_STATS_SIZE(SystemConstant.LOTTO_RANK_COUNT.value + SystemConstant.WINNING_STATS_START.getValue()),
    NOTHING(0),
    MULT_FACTOR(10000),
    DIV_FACTOR(100);

    private final int value;

    SystemConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public long getValueToLong() {
        return value;
    }
}
