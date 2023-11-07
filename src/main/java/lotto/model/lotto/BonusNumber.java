package lotto.model.lotto;

import static lotto.utils.LottoConstant.MAX_NUMBER;
import static lotto.utils.LottoConstant.MIN_NUMBER;

import java.util.List;
import lotto.exception.lotto.LottoDuplicateException;
import lotto.exception.lotto.LottoOutOfRangeException;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, WinningLotto winningLotto) {
        validateBonusNumberRange(bonusNumber);
        validateNotDuplicate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public int getValue() {
        return bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getValue() || bonusNumber > MAX_NUMBER.getValue()) {
            throw new LottoOutOfRangeException();
        }
    }

    private void validateNotDuplicate(int bonusNumber, WinningLotto winningLotto){
        List<Integer> winningNumbers = winningLotto.getNumbers();
        if (winningNumbers.contains(bonusNumber)){
            throw new LottoDuplicateException();
        }
    }



}
