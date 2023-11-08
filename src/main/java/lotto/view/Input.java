package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private final InputValidator inputValidator = new InputValidator();

    public String readMoney() {
        return inputValidator.validateDigit(read());
    }

    public String readWinningNumbers() {
        return inputValidator.validateNumberAndDelimiterFormat(read());
    }

    public String readBonusNumber() {
        return inputValidator.validateDigit(read());
    }

    private String read() {
        return inputValidator.validateNotEmpty(Console.readLine());
    }
}
