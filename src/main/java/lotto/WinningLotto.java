package lotto;

import static lotto.validation.WinningLottoValidation.ValidateBonusNumberRange;
import static lotto.validation.WinningLottoValidation.validateDuplicateNumbersAndBonus;

public class WinningLotto {
    public final int bonusNumber;
    private final Lotto lotto;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        validateDuplicateNumbersAndBonus(lotto, bonusNumber);
        ValidateBonusNumberRange(bonusNumber);
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
