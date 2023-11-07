package lotto.domain;

import static lotto.utils.LottoConstants.END_NUMBER;
import static lotto.utils.LottoConstants.START_NUMBER;

import java.util.List;
import lotto.exception.IllegalSameNumberException;
import lotto.exception.OutOfRangeNumbersException;

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
            throw new IllegalSameNumberException();
        }
    }

    private void checkBonusNumberInRange(Integer bonusNumber) {
        if (bonusNumber < START_NUMBER.getValue() || bonusNumber > END_NUMBER.getValue()) {
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
