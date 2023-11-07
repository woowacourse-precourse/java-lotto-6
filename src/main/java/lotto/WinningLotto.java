package lotto;

import static lotto.validation.WinningLottoValidation.ValidateBonusNumberRange;
import static lotto.validation.WinningLottoValidation.validateDuplicateNumbersAndBonus;

public class WinningLotto {
    private final Lotto lotto;
    public final int bonusNumber;

    public WinningLotto() {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        validateDuplicateNumbersAndBonus(lotto, bonusNumber);
        ValidateBonusNumberRange(bonusNumber);
    }
}
