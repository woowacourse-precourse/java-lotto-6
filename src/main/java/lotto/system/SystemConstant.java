package lotto.system;

public enum SystemConstant {
    LOTTO_TICKET_PRICE(1000),
    WINNING_STATS_START(1),
    WINNING_STATS_SIZE(LottoRankConstant.values().length + SystemConstant.WINNING_STATS_START.getValue()),
    NOTHING(0),
    CUNVERT_PERCENTAGE_FACTOR(100);

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
