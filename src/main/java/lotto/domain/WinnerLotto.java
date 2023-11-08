package lotto.domain;

import java.util.List;
import lotto.exception.DuplicateNumberException;

public class WinnerLotto {

    private final BonusNumber bonusNumber;
    private final Lotto lotto;

    public WinnerLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        validateDuplicateBonus(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean matchesLottoNumber(int lottoNumber) {
        return lotto.getNumbers()
                .contains(lottoNumber);
    }

    public boolean matchesBonusNumber(int bonusNumber) {
        return this.bonusNumber.equals(bonusNumber);
    }

    private void validateDuplicateBonus(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new DuplicateNumberException();
        }
    }
}
