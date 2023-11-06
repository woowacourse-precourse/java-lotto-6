package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int inputNumber(String inputMessage) {
        printInputMessage(inputMessage);
        String inputValue = Console.readLine();

        return parseNumber(inputValue);
    }

    private static void printInputMessage(String inputMessage) {
        System.out.println(inputMessage);
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }

    public static List<Integer> inputNumbersWithDelimiter(String inputMessage, String delimiter) {
        printInputMessage(inputMessage);
        String inputValue = Console.readLine();

        return splitInputValueWithDelimiter(inputValue, delimiter);
    }

    private static List<Integer> splitInputValueWithDelimiter(String inputValue, String delimiter) {
        return Arrays.stream(inputValue.split(delimiter))
                .map(InputView::parseNumber)
                .toList();
    }

    public static int inputExcludingSpecifiedNumbers(String inputMessage, List<Integer> excludingNumbers) {
        printInputMessage(inputMessage);
        int inputNumber = parseNumber(Console.readLine());

        checkExcludingNumber(inputNumber, excludingNumbers);

        return inputNumber;
    }

    private static void checkExcludingNumber(int inputNumber, List<Integer> excludingNumbers) {
        if (excludingNumbers.contains(inputNumber)) {
            throw new IllegalArgumentException("입력할 수 없는 값입니다.");
        }
    }
}
