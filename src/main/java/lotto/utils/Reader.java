package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InvalidCommaMissingException;
import lotto.exception.InvalidNonNumericInputException;

public class Reader {
    public static int parseNumberInteger() {
        try {
            String inputNumber = Console.readLine();
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new InvalidNonNumericInputException();
        }
    }

    public static List<Integer> parseNumbersInteger() {
        String inputNumbers = Console.readLine();
        if (!inputNumbers.contains(",")) {
            throw new InvalidCommaMissingException();
        }
        return convertToNumbers(inputNumbers);
    }

    private static List<Integer> convertToNumbers(String inputNumbers) {
        try {
            return Arrays.stream(inputNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidNonNumericInputException();
        }
    }
}
