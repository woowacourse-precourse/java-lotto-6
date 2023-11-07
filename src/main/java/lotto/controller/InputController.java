package lotto.controller;

import lotto.domain.TicketAmount;
import lotto.domain.WinningNumber;
import lotto.domain.BonusNumber;
import lotto.util.Validator;
import lotto.view.InputView;

public class InputController {
    public TicketAmount setTicketAmount() {
        try {
            String input = InputView.inputMoney();
            validateInput(input);
            return new TicketAmount(input);
        } catch (IllegalArgumentException e) {
            return setTicketAmount();
        }
    }

    public WinningNumber setWinningNumber() {
        try {
            String input = InputView.inputLottoNumbers();
            validateWinningNumberInput(input);
            return new WinningNumber(input);
        } catch (IllegalArgumentException e) {
            return setWinningNumber();
        }
    }

    public BonusNumber setBonusNumber(WinningNumber winningNumber) {
        try {
            String input = InputView.inputBonusNumber();
            validateInput(input);
            return new BonusNumber(winningNumber, input);
        } catch (IllegalArgumentException e) {
            return setBonusNumber(winningNumber);
        }
    }

    private void validateInput(String input) {
        Validator.validateInputNotEmpty(input);
        Validator.validateIsParsableToInt(input);
    }

    private void validateWinningNumberInput(String input) {
        Validator.validateInputNotEmpty(input);
        Validator.validateInputWithSeparator(input);
    }
}
