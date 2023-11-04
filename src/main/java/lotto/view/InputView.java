package lotto.view;

import static lotto.constant.message.ErrorMessage.BLANK_LINE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestInputValue(String message) {
        System.out.println(message);
        String input = Console.readLine();

        validateEmptyLine(input);
        return input;
    }

    private void validateEmptyLine(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_LINE.getMessage());
        }
    }

}
