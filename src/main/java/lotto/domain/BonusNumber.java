package lotto.domain;

import lotto.view.InputView;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber() {
        bonusNumber = InputView.readBonusNumber();
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
