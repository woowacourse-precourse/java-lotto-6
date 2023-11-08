package lotto.domain.number;

import lotto.domain.lotto.WinningLotto;
import lotto.dto.request.BonusNumberRequest;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(BonusNumberRequest bonusNumber, WinningLotto winningLotto){
        this.bonusNumber = createBonusNumber(bonusNumber);
        winningLotto.validateIsDuplicate(this.bonusNumber);
    }

    private int createBonusNumber(BonusNumberRequest bonusNumber){
        return Integer.parseInt(bonusNumber.getBonusNumber());

    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}