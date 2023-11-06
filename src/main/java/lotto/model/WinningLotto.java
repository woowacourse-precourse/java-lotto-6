package lotto.model;

import lotto.validator.WinningNumberValidator;

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

    // 당첨로또와 비교하여 등수 내는 메서드 필요함
}
