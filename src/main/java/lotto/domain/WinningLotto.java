package lotto.domain;

import java.util.List;
import lotto.exception.OutOfRangeNumbersException;
import lotto.exception.WrongSameNumberException;
import lotto.utils.ValueUnit;

public class WinningLotto extends Lotto {

    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        checkSameNumbers(numbers, bonusNumber);
        checkBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkSameNumbers(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new WrongSameNumberException();
        }
    }

    private void checkBonusNumberInRange(Integer bonusNumber) {
        ValueUnit startNumber = ValueUnit.START_NUMBER;
        ValueUnit endNumber = ValueUnit.END_NUMBER;
        if (bonusNumber < startNumber.getValue() || bonusNumber > endNumber.getValue()) {
            throw new OutOfRangeNumbersException();
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinnerNumbers() {
        return getLottoNumbers();
    }
}
