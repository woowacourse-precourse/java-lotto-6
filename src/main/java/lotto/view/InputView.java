package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.WinningNumber;
import lotto.message.ErrorMessage;
import lotto.message.InputMessage;

public class InputView {

    public static int getPrice() {
        InputMessage.PRICE_PROMPT.print();
        String input = readLine();
        if (!isNumericValue(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
        int price = Integer.parseInt(input);
        if (price < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PRICE_VALUE.getMessage());
        }
        return price;
    }

    private static boolean isNumericValue(String input) {
        char[] data = input.toCharArray();
        int index = 0;

        if (data[index] == '-') {
            index++;
        }
        for (int i = index; i < data.length; i++) {
            if (!Character.isDigit(data[i])) {
                return false;
            }
        }
        return true;
    }

    public static WinningNumber getWinningNumbers() {
        InputMessage.WINNING_NUMBER_PROMPT.print();

        String input = readLine();
        return WinningNumber.fromString(input);
    }

    public static int getBonusNumber() {
        InputMessage.BONUS_NUMBER_PROMPT.print();

        String input = readLine();
        if (!isNumericValue(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
        int number = Integer.parseInt(input);
        if (!hasCorrectRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
        return number;
    }

    private static boolean hasCorrectRange(int number) {
        return number > 0 && number < 46;
    }
}
