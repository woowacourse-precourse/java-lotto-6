package lotto.domain.lottery;

import lotto.utils.message.LottoExceptionMessage;

public class WinningInformation {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningInformation(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.isContains(bonusNumber)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessage.WINNING_AND_BONUS_DUPLICATE_EXISTS.getError());
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
