package lotto.utils;

import lotto.model.Profit;
import static lotto.constant.UtilsConstant.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class FormatUtils {

    public static String DecimalFormatter(Profit profit) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT_PATTERN);
        return decimalFormat.format(profit.getProfitRate());
    }

    public static List<Integer> stringToList(String inputLotto) {
        return Arrays.stream(inputLotto.split(SPLIT_STREAM_REGEX))
                .map(Integer::parseInt)
                .toList();
    }

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

}
