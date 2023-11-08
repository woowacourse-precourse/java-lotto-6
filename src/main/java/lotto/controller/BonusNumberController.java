package lotto.controller;

import lotto.model.BonusNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusNumberController {
    OutputView outputView = new OutputView();

    public int setBonusNumber() {
        String bonusNumber;
        while (true) {
            try {
                outputView.printInsertBonusNumber();
                bonusNumber = InputView.insertBonusNumber();
                new BonusNumberValidator(bonusNumber);
                return InputView.convertToInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
