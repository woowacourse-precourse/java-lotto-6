package lotto.domain;

import java.text.DecimalFormat;

public enum LottoPrize {

    FIFTH_PRIZE(5_000L, 3, 0),
    FOURTH_PRIZE(50_000L, 4, 0),
    THIRD_PRIZE(1_500_000L, 5, 0),
    SECOND_PRIZE(30_000_000L, 5, 1),
    FIRST_PRIZE(2_000_000_000L, 6, 0),
    NONE(0L, 0, 0);

    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("###,###");
    private final long winningAmount;
    private final int numNumberMatches;
    private final int numBonusNumberMatches;

    LottoPrize(long winningAmount, int numNumberMatches, int numBonusNumberMatches) {
        this.winningAmount = winningAmount;
        this.numNumberMatches = numNumberMatches;
        this.numBonusNumberMatches = numBonusNumberMatches;
    }


    public boolean matches(int numNumberMatches, int numBonusNumberMatches) {
        if (this.equals(SECOND_PRIZE) || this.equals(THIRD_PRIZE)) {
            return this.numNumberMatches == numNumberMatches &&
                    this.numBonusNumberMatches == numBonusNumberMatches;
        }

        return this.numNumberMatches == numNumberMatches;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.numNumberMatches).append("개 일치");
        if (this.numBonusNumberMatches != 0) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(DECIMAL_FORMATTER.format(winningAmount)).append("원) - ");
        return sb.toString();
    }
}
