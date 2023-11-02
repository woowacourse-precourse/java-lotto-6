package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readPurchaseAmount() {
        final String input = Console.readLine();
        inputValidator.validatePurchaseAmount(input);
        return input;
    }
}
