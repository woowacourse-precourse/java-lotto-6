package lotto.util;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class StringUtil {

    public static List<String> toStringList(List<Integer> numbers) {
        return numbers.stream()
                .map(Objects::toString)
                .toList();
    }

    public static String toStringWithCommas(Integer number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}
