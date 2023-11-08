package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exception.Exception.INVALID_BONUS_NUMBER_INPUT_TYPE;
import static lotto.exception.Exception.INVALID_WINNING_NUMBERS_INPUT_TYPE;
import static lotto.exception.Exception.ONLY_NUMERIC_INPUT_FOR_MONEY;
import static lotto.validator.BonusNumberValidator.validate;
import static lotto.validator.LottoValidator.validate;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public static int inputMoney() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_FOR_MONEY.getMessage());
        }
    }

    public static List<Integer> inputWinningNumbers() {
        String input = readLine();
        List<Integer> numbers = convertToIntegers(input);
        validate(numbers);
        return numbers;
    }

    private static String removeSpace(String input) {
        return input.replace(" ", "");
    }

    private static String[] splitWinningNumbers(String input) {
        return input.split(WINNING_NUMBERS_DELIMITER);
    }

    private static List<Integer> convertToIntegers(String input) {
        String[] numbers = splitWinningNumbers(removeSpace(input));
        try {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT_TYPE.getMessage());
        }
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(readLine());
            validate(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_INPUT_TYPE.getMessage());
        }
    }
}
