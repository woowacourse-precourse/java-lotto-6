package lotto.controller;

import lotto.domain.TicketAmount;
import lotto.domain.WinningNumber;
import lotto.domain.BonusNumber;
import lotto.view.InputView;

public class InputController {
    private InputController() {
    }
    public static TicketAmount setTicketAmount() {
        while (true) {
            try {
                String input = InputView.inputMoney();
                return new TicketAmount(input);
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }

    public static WinningNumber setWinningNumber() {
        while (true) {
            try {
                String input = InputView.inputLottoNumbers();
                return new WinningNumber(input);
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }

    public static BonusNumber setBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                String input = InputView.inputBonusNumber();
                return new BonusNumber(winningNumber, input);
            } catch (IllegalArgumentException e) {
                e.getMessage();
            }
        }
    }
}
