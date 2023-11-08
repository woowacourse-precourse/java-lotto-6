package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String INPUT_IS_NOT_POSTIVE_NUMBER_ERROR = "양수를 입력해 주세요.";
    private static final String INPUT_IS_NOT_NUMBER_ERROR = "문자가 아닌 숫자를 입력해 주세요.";
    private static final String INPUT_IS_WRONG = "올바른 숫자를 입력해 주세요.";

    public static int readCash() {
        return convertToPositiveNumber(Console.readLine());
    }

    public static List<Integer> readWinningNumber() {
        return splitToList(Console.readLine());
    }

    private static List<Integer> splitToList(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(InputView::convertToPositiveNumber)
                .collect(Collectors.toList());
    }

    private static int convertToPositiveNumber(String input) {
        int number;
        try {
            validateNumeric(input);
            number = Integer.parseInt(input);
            validatePostiveNumber(number);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INPUT_IS_WRONG);
        }
        return number;
    }

    private static void validateNumeric(String input) {
        if (input != null && input.matches("![0-9]]")) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER_ERROR);
        }
    }

    private static void validatePostiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(INPUT_IS_NOT_POSTIVE_NUMBER_ERROR);
        }
    }

}
