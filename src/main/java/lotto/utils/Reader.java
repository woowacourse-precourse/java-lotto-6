package lotto.utils;

import static lotto.constants.Error.NON_DELIMITER;
import static lotto.constants.Error.NUMERIC_INVALID;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    public static int parseNumberInteger() {
        try {
            String inputNumber = Console.readLine();
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_INVALID.getMessage());
        }
    }

    public static List<Integer> parseNumbersInteger() {
        String inputNumbers = Console.readLine();
        if (!inputNumbers.contains(",")) {
            throw new IllegalArgumentException(NON_DELIMITER.getMessage());
        }
        return convertToNumbers(inputNumbers);
    }

    private static List<Integer> convertToNumbers(String inputNumbers) {
        try {
            return Arrays.stream(inputNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_INVALID.getMessage());
        }
    }
}
