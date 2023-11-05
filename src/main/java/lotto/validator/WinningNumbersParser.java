package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersParser {
    public static List<Integer> splitAndConvertToIntegers(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
