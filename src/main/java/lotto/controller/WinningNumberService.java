package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.utils.InputUtils;
import lotto.utils.ValidateUtils;

public class WinningNumberService {
    private WinningNumber winningNumber;

    public void makeWinningNumber(Lotto winningNumbers, int bonusNumber) {
        winningNumber = new WinningNumber(winningNumbers, bonusNumber);
    }

    public int makeBonusNumber() {
        try {
            String input = InputUtils.input();
            ValidateUtils.validateNumberNumeric(input);
            int bonusNumber = Integer.parseInt(input);
            ValidateUtils.validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeBonusNumber();
        }
    }

    public Lotto getWinningLotto() {
        return winningNumber.getWinningNumbers();
    }

    public int getBonusNumber() {
        return winningNumber.getBonusNumber();
    }

}
