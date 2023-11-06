package lotto.service;

import lotto.controller.InputController;
import lotto.domain.WinningNumbers;

public class WinningNumberGenerator {

    public WinningNumbers generate() {
        return new WinningNumbers(
                InputController.inputWinningNumber(),
                InputController.inputBonusNumber());
    }
}
