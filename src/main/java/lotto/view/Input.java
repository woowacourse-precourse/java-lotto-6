package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private final InputValidator inputValidator = new InputValidator();

    public String readMoney() {
        return inputValidator.validateNumberFormat(read());
    }

    public String readWinningNumbers() {
        return read();
    }

    public String readBonusNumber() {
        return inputValidator.validateNumberFormat(read());
    }

    private String read() {
        return inputValidator.validateNotEmpty(Console.readLine());
    }
}
