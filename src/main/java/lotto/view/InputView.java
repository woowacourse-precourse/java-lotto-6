package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.WinningNumber;
import lotto.message.Error;
import lotto.message.Input;
import lotto.util.Validation;

public class InputView {

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

    public static WinningNumber getWinningNumbers() {
        Input.WINNING_NUMBER_PROMPT.print();

        String input = readLine();
        return WinningNumber.fromString(input);
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
}
