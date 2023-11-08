package lotto.model;


import java.util.List;
import lotto.exception.DuplicateNumberInBonusNumberException;
import lotto.exception.NumberNotInRangeException;

public class WinningLotto {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        try {
            validateBonusNumberDuplicateInNumbers(bonusNumber);
            validateNumbersInRange(bonusNumber);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateBonusNumberDuplicateInNumbers(Integer bonusNumber) {
        for (Integer number : lotto.getNumbers()) {
            if (number.equals(bonusNumber)) {
                throw new DuplicateNumberInBonusNumberException();
            }
        }
    }

    private void validateNumbersInRange(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new NumberNotInRangeException();
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public Lotto getLotto() {
        return lotto;
    }
}
