package lotto.model;

import static lotto.error.ErrorMessage.NOT_UNIQUE_BONUS_NUMBER;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(
            final Lotto lotto,
            final BonusNumber bonusNumber
    ) {
        validateDuplicatedNumber(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicatedNumber(Lotto numbers, BonusNumber bonusNumber) {
        boolean duplicated = numbers.getNumbers()
                .contains(bonusNumber.getNumber());

        if (duplicated) {
            throw new IllegalArgumentException(NOT_UNIQUE_BONUS_NUMBER.getMessage());
        }
    }

}
