package lotto.model;

import lotto.validator.BonusNumberValidator;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        BonusNumberValidator.validateContainBonusNumInWinningLotto(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = BonusNumber.getInstance(bonusNumber);
    }

    public static WinningLotto getInstance(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
