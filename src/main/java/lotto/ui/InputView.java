package lotto.ui;

import static lotto.enums.PrintMessage.REQUEST_AMOUNT;
import static lotto.enums.PrintMessage.REQUEST_BONUS_NUMBER;
import static lotto.enums.PrintMessage.REQUEST_WINNING_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String scanAmount() {
        System.out.println(REQUEST_AMOUNT.getMassage());
        return scanInput();
    }

    public String scanWinningLottoNumber() {
        System.out.println(REQUEST_WINNING_LOTTO_NUMBER.getMassage());
        return scanInput();
    }

    public String scanBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER.getMassage());
        return scanInput();
    }

    private String scanInput() {
        String input = Console.readLine();
        inputValidator.validate(input);
        System.out.println();
        return input;
    }
}
