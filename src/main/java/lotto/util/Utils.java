package lotto.util;

import lotto.configure.OutputConfiguration;

public class Utils {

    public static String round(double toRound) {
        return String.format("%." + (OutputConfiguration.DECIMAL_POINT_TO_ROUND - 1) + "f", toRound);
    }
}
