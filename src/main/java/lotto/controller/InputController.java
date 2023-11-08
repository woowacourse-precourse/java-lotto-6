package lotto.controller;

import lotto.domain.TicketAmount;
import lotto.domain.WinningNumber;
import lotto.domain.BonusNumber;
import lotto.util.Validator;
import lotto.view.InputView;

public class InputController {
    private InputController() {
    }
    public static TicketAmount setTicketAmount() {
        try {
            String input = InputView.inputMoney();
            return new TicketAmount(input);
        } catch (IllegalArgumentException e) {
            return setTicketAmount();
        }
    }

    public static WinningNumber setWinningNumber() {
        try {
            String input = InputView.inputLottoNumbers();
            return new WinningNumber(input);
        } catch (IllegalArgumentException e) {
            return setWinningNumber();
        }
    }

    public static BonusNumber setBonusNumber(WinningNumber winningNumber) {
        try {
            String input = InputView.inputBonusNumber();
            return new BonusNumber(winningNumber, input);
        } catch (IllegalArgumentException e) {
            return setBonusNumber(winningNumber);
        }
    }
}
