package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.input.InputCommonValidator;

public class InputNumberReader {

    private InputNumberReader() {
    }

    public static int readNumber() {
        String inputNumber = readLine().trim();
        InputCommonValidator.validateNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    public static List<Integer> readNumbers(final String delimiter) {
        List<String> inputNumbers = Arrays.stream(readLine().split(delimiter))
                .map(String::trim)
                .toList();
        InputCommonValidator.validateNumbers(inputNumbers);
        return convertToNumbers(inputNumbers);
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static List<Integer> convertToNumbers(final List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
