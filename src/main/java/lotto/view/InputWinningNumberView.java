package lotto.view;

import static lotto.config.GameNumberConfig.LOTTO_NUMBER_COUNT;
import static lotto.config.GameTextConfig.LOTTO_NUMBER_SEPARATOR;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_LOTTO_LENGTH;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_NUMBER;
import static lotto.view.constants.OutputMessage.INPUT_WINNING_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputWinningNumberView {
    private static final int INPUT_SEPARATOR_COUNT = (LOTTO_NUMBER_COUNT.getValue() - 1) * LOTTO_NUMBER_SEPARATOR.getValue().length();

    private InputWinningNumberView() {
    }

    public static List<Integer> inputWinningNumber() {
        OutputView.printMessage(INPUT_WINNING_NUMBER_MESSAGE.getMessage());

        String input = Console.readLine();
        validateWinningNumber(input);
        return parseWinningNumber(input);
    }

    private static void validateWinningNumber(String input) {
        checkSeparatorCount(input);
    }

    private static void checkSeparatorCount(String input) {
        Pattern pattern = Pattern.compile(LOTTO_NUMBER_SEPARATOR.getValue());
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        if (count != INPUT_SEPARATOR_COUNT) {
            throw new IllegalArgumentException(VALIDATE_INPUT_LOTTO_LENGTH.getMessage());
        }
    }

    private static List<Integer> parseWinningNumber(String input) {
        List<String> splitInput = splitBySeparator(input);
        List<Integer> numbers = parseIntList(splitInput);
        return numbers;
    }

    private static List<String> splitBySeparator(String input) {
        return Arrays.asList(input.split(LOTTO_NUMBER_SEPARATOR.getValue()));
    }

    private static List<Integer> parseIntList(List<String> input){
        try {
            return new ArrayList<>(input.stream()
                    .map(Integer::parseInt)
                    .toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_INPUT_NUMBER.getMessage());
        }
    }
}
