package lotto.domain;

import static lotto.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR;

public final class WinningNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    public WinningResult getWinningResult(Lotto lotto) {
        int matchCount = lotto.countMatchNumbers(winningNumbers);
        boolean matchBonus = lotto.contains(bonusNumber);
        return WinningResult.of(matchCount, matchBonus);
    }
}
