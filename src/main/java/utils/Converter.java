package utils;

import java.util.Arrays;
import java.util.stream.Collectors;
import model.Lotto;

public class Converter {

    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
    public static String[] splitByDelimiter(String winningNumbers, String delimiter) {
        return winningNumbers.split(delimiter);
    }

    public static Lotto stringToLotto(String winningNumbers, String delimiter) {
        return new Lotto(Arrays.stream(splitByDelimiter(winningNumbers, delimiter)).map(Converter::stringToInt)
                .collect(Collectors.toList()));
    }
}
