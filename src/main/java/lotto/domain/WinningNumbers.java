package lotto.domain;

import static lotto.util.Instruction.ERROR_DUPLICATE_BONUS_NUMBER_EXISTENCE;

public class WinningNumbers {
    private final Lotto answerLotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final Lotto answerLotto, final LottoNumber bonusNumber) {
        this.answerLotto = answerLotto;
        isValidDuplication(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void isValidDuplication(final LottoNumber bonusNumber) {
        if (answerLotto.hasElement(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER_EXISTENCE.getMessage());
        }
    }
}
