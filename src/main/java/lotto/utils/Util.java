package lotto.utils;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static final List<Integer> convertStringToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static final boolean isInteger(String str) {
        return str.matches("\\d+");
    }

    public static final NumberFormat createNumberFormatWithFractionDigits(double value) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(1);
        nf.setMinimumFractionDigits(1);
        return nf;
    }
}
