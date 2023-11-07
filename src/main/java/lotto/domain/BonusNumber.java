package lotto.domain;

import lotto.view.InputView;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber() {
        bonusNumber = inputBonusNumber();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int inputBonusNumber() {
        System.out.println();
        return InputView.inputBonusNumbers();
    }
}
