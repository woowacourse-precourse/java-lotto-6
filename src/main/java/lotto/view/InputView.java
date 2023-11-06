package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Exception.INVALID_BONUS_NUMBER_INPUT_TYPE;
import static lotto.Exception.INVALID_WINNING_NUMBERS_INPUT_TYPE;
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
        String input = readLine();
        String[] numbers = splitWinningNumbers(removeSpace(input));
        return convertToIntegers(numbers);
    }

    private String removeSpace(String input) {
        return input.replace(" ", "");
    }

    private String[] splitWinningNumbers(String input) {
        return input.split(WINNING_NUMBERS_DELIMITER);
    }

    private List<Integer> convertToIntegers(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT_TYPE.getMessage());
        }
    }

    public int inputBonusNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_INPUT_TYPE.getMessage());
        }
    }
}
