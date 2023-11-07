package lotto.dto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, BonusNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, BonusNumber bonusNumber) {
        if (hasDuplicateNumber(winningLotto, bonusNumber)) {
            throw new LottoGameException(ErrorMessage.DUPLICATE_INPUT);
        }
    }

    private boolean hasDuplicateNumber(Lotto winningLotto, BonusNumber bonusNumber) {
        return winningLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
