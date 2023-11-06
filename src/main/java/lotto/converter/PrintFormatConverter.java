package lotto.converter;

import java.text.DecimalFormat;

public final class PrintFormatConverter {

    private static final String REWARD_PATTERN = "#,###원";
    private static final String YIELD_PATTERN = "#,##0.0";

    private PrintFormatConverter() {
    }

    public static String convertToRewardFormat(final int reward) {
        DecimalFormat rewardFormat = new DecimalFormat(REWARD_PATTERN);
        return rewardFormat.format(reward);
    }

    public static String convertToYieldFormat(final double yield) {
        DecimalFormat yieldFormat = new DecimalFormat(YIELD_PATTERN);
        return yieldFormat.format(yield);
    }

}
