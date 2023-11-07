package lotto.utils;

import lotto.model.Profit;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class FormatUtils {

    public static String DecimalFormatter(Profit profit) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(profit.getProfitRate());
    }

    public static List<Integer> stringToList(String inputLotto) {
        return Arrays.stream(inputLotto.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

}
