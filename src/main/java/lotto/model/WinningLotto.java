package lotto.model;

import java.util.List;
import lotto.exception.DuplicateNumbersException;

public class WinningLotto {

    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLotto(final Lotto lotto, final Number bonusNumber) {
        validateLottoNumbers(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private static void validateLottoNumbers(final Lotto lotto, final Number bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new DuplicateNumbersException();
        }
    }

    public boolean hasMatchingBonus(final List<Number> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int countMatchingNumbers(final List<Number> lottoNumbers) {
        return lotto.countMatchingNumbers(lottoNumbers);
    }
}
