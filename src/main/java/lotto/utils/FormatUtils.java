package lotto.utils;

import lotto.constant.UtilsConstant;

import java.util.Arrays;
import java.util.List;

public class FormatUtils {

    public static List<Integer> stringToList(String inputLotto) {
        return Arrays.stream(inputLotto.split(UtilsConstant.SPLIT_STREAM_REGEX))
                .map(Integer::parseInt)
                .toList();
    }

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static String parseFormattedDoubleValue(double rate) {
        return String.format(UtilsConstant.FORMAT_DOUBLE_VALUE,rate);
    }

    public static String formatPriceWithCommas(int price) {
        return String.format(UtilsConstant.FORMAT_PRICE_WITH_COMMA,price);
    }

}
