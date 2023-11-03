package lotto.view;

import static lotto.constant.message.ErrorMessage.BLANK_LINE;
import static lotto.constant.message.ErrorMessage.NOT_ONLY_DIGIT;
import static lotto.constant.message.InputMessage.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int requestAndParseInt(String message) throws IllegalArgumentException {
        System.out.println(message);
        String input = Console.readLine();

        validateEmptyLine(input);
        validateOnlyDigit(input);
        return Integer.parseInt(input);
    }

    public void requestWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    private void validateOnlyDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT.getMessage());
        }
    }

    private void validateEmptyLine(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_LINE.getMessage());
        }
    }

}
