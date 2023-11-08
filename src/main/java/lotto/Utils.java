package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> convertStringToIntegerList(String commaSeparatedNumbers) {
        List<Integer> parsedNumbers = Arrays.stream(commaSeparatedNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return parsedNumbers;
    }

    public static String formatAndRoundNumber(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(number);
    }

}
