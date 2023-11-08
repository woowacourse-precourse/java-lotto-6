package lotto.domain.lotto;

import static lotto.io.ErrorMessage.DUPLICATE_BONUS_NUMBER;

public class WinningNumber {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto lotto, BonusNumber bonusNumber) {
        validateUniqueNumbers(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateUniqueNumbers(Lotto lotto, BonusNumber bonusNumber) {
        for (Integer num : lotto.getNumbers()) {
            if (bonusNumber.getNumber() == num) {
                throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
            }
        }
    }
}
