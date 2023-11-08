package lotto.model;

import lotto.model.exceptions.DuplicatedNumberException;

public record WinLotto(Lotto winNumbers, BonusNumber bonusNumber) {

    public WinLotto {
        checkDuplicateNumber(winNumbers, bonusNumber);
    }

    private void checkDuplicateNumber(Lotto winNumbers, BonusNumber bonusNumber) {
        if (winNumbers.contains(bonusNumber.number())) {
            throw new DuplicatedNumberException();
        }
    }
}