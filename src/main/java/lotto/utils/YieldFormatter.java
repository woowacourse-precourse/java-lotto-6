package lotto.utils;

import static lotto.constant.LottoConstant.PERCENT;
import static lotto.constant.LottoConstant.YIELD_FORMAT;

public class YieldFormatter {
    public static String format(double value) {
        return String.format(YIELD_FORMAT, value) + PERCENT;
    }
}
