package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.message.ErrorMessage;

public class InputView {

    public static int getPrice() {
        String input = readLine();
        if (isDigit(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
        int price = Integer.parseInt(input);
        if (price < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PRICE_VALUE.getMessage());
        }
        return price;
    }

    private static boolean isDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
