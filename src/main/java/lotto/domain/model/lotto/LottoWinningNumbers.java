package lotto.domain.model.lotto;

import lotto.error.ErrorMessage;

public class LottoWinningNumbers {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumbers(final Lotto winningNumbers, final LottoNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(final Lotto winningNumbers, final LottoNumber bonusNumber) {
        if (hasDuplicates(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicates(final Lotto winningNumbers, final LottoNumber bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

}
