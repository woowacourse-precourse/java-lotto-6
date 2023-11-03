package lotto.domain;

import lotto.io.InputHandler;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber() {
        bonusNumber = InputHandler.readBonusNumber();
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
