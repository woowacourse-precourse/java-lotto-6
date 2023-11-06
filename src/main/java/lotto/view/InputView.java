package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Exception.ONLY_NUMERIC_INPUT_FOR_MONEY;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private final String WINNING_NUMBERS_DELIMITER = ",";
    public int inputMoney() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_FOR_MONEY.getMessage());
        }
    }

    public List<Integer> inputWinningNumbers() {
        String input = removeSpace(readLine());
        String[] numbers = splitWinningNumbers(input);

        return convertToIntegers(numbers);
    }

    private String removeSpace(String input) {
        return input.replace(" ", "");
    }

    private String[] splitWinningNumbers(String input) {
        return input.split(WINNING_NUMBERS_DELIMITER);
    }

    private List<Integer> convertToIntegers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }
}
