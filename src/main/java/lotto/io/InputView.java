package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readPurchaseAmount() {
        final String input = Console.readLine();
        inputValidator.validateNumeric(input);
        return input;
    }
}
