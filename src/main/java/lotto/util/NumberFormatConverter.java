package lotto.util;

import java.text.DecimalFormat;

public final class NumberFormatConverter {

    private NumberFormatConverter() {
    }

    public static String convertToRewardFormat(final int reward) {
        DecimalFormat rewardFormat = new DecimalFormat("#,###원");
        return rewardFormat.format(reward);
    }

    public static String convertToYieldFormat(final double yield) {
        DecimalFormat yieldFormat = new DecimalFormat("#,##0.0");
        return yieldFormat.format(yield);
    }

}
