package lotto.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertorUtil {

    public static List<String> convertToList(final String str) {
        return Arrays.stream(str.split(","))
                .map(String::trim)
                .toList();
    }

    public static String convertToString(List<Integer> list) {
        return "[" +
                list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) +
                "]";
    }

    public static String convertToStringFormat(Integer number) {
        return new DecimalFormat("#,###")
                .format(number);
    }
}
