package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.LottoNumbers;
import lotto.exception.DuplicatedNumberException;
import lotto.exception.OutOfRangeException;

public class WinningLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        if (isNotInRange(bonusNumber)) {
            System.out.println(ErrorMessages.IN_RANGE.getDeclaringClass());
            throw new OutOfRangeException(ErrorMessages.IN_RANGE.getErrorMessage());
        }
        if (lotto.contains(bonusNumber)) {
            System.out.println(ErrorMessages.NOT_DUPLICATE.getErrorMessage());
            throw new DuplicatedNumberException(ErrorMessages.NOT_DUPLICATE.getErrorMessage());
        }
    }

    private boolean isNotInRange(Integer bonusNumber) {
        return bonusNumber < LottoNumbers.MIN_RANGE.getNumber() || bonusNumber > LottoNumbers.MAX_RANGE.getNumber();
    }

    public Integer matchCount(Lotto other) {
        return lotto.matchCount(other);
    }

    public boolean containsBonusNumber(Lotto other) {
        return other.contains(bonusNumber);
    }
}
