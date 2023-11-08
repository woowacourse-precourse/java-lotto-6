package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String INPUT_IS_NOT_POSTIVE_NUMBER_ERROR = "양수를 입력해 주세요.";
    private static final String INPUT_IS_NOT_NUMBER_ERROR = "문자가 아닌 숫자를 입력해 주세요.";

    public static int readCash() {
        int cash = StringToInteger(Console.readLine());
        validatePostiveNumber(cash);
        return cash;
    }

    private static int StringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER_ERROR);
        }
    }

    private static void validatePostiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(INPUT_IS_NOT_POSTIVE_NUMBER_ERROR);
        }
    }

    public static List<Integer> readWinningNumber() {
        return splitToList(Console.readLine());
    }

    private static List<Integer> splitToList(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(InputView::StringToInteger)
                .peek(InputView::validatePostiveNumber)
                .collect(Collectors.toList());
    }

}
