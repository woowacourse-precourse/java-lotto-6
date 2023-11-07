package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER;

public class LuckyNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public LuckyNumbers(Lotto winningNumbers, LottoNumber bonusNuber) {
        validate(winningNumbers, bonusNuber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNuber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_AND_BONUS_NUMBER.get());
        }
    }
}
