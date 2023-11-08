package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.message.Error;
import lotto.message.Input;
import lotto.util.Validation;

public class InputView {

    private static final String winningNumberDelimiter = ",";

    public static int getPrice() {
        Input.PRICE_PROMPT.print();
        String input = readLine();
        if (!Validation.isNumericValue(input)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT.getMessage());
        }
        int price = Integer.parseInt(input);
        if (!Validation.isPositive(price)) {
            throw new IllegalArgumentException(Error.NEGATIVE_PRICE_VALUE.getMessage());
        }
        return price;
    }

    public static List<Integer> getWinningNumbers() {
        Input.WINNING_NUMBER_PROMPT.print();

        String input = readLine();
        if (!hasCorrectFormat(input)) {
            throw new IllegalArgumentException(Error.INVALID_INPUT_FORMAT.getMessage());
        }
        return parseString(input);
    }

    public static int getBonusNumber() {
        Input.BONUS_NUMBER_PROMPT.print();

        String input = readLine();
        if (!Validation.isNumericValue(input)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT.getMessage());
        }
        int number = Integer.parseInt(input);
        if (!Validation.hasCorrectRange(number)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_RANGE.getMessage());
        }
        return number;
    }

    private static boolean hasCorrectFormat(String input) {
        String[] tokens = input.split(winningNumberDelimiter);

        return Arrays.stream(tokens).allMatch(Validation::isNumericValue);
    }

    private static List<Integer> parseString(String input) {
        String[] tokens = input.split(winningNumberDelimiter);

        try {
            return Arrays.stream(tokens).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
