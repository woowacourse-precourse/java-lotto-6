package lotto.model;

import lotto.validator.WinningNumberValidator;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException {
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
