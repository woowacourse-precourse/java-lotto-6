package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.view.InputBonusNumberView;
import lotto.view.OutputView;

public class BonusNumberService {

    public BonusNumber craeteBonusNumber(Lotto lotto) {
        do {
            try {
                int number = InputBonusNumberView.inputBonusNumber();
                return new BonusNumber(lotto, number);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        } while (true);
    }
}
