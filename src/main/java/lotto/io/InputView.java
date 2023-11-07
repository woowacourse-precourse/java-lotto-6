package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readPurchaseAmount() {
        final String input = Console.readLine();
        inputValidator.validateNull(input);
        inputValidator.validateNumeric(input);
        return input;
    }

    public String readWinningLottoNumber() {
        final String input = Console.readLine();
        inputValidator.validateNull(input);
        inputValidator.validateHasDelimiter(input);
        return input;
    }

    public String readBonusNumber() {
        final String input = Console.readLine();
        inputValidator.validateNull(input);
        inputValidator.validateNumeric(input);
        return input;
    }
}
