package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.exception.InvalidLottoNumberException;

import java.util.List;

public class Jackpot {
    private Lotto lotto;
    private int bonusNumber;

    public Jackpot(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public void validate(Lotto lotto, int bonusNumber) {
        bonusNumberCheck(lotto, bonusNumber);
    }

    private void bonusNumberCheck(Lotto lotto, int bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        if(numbers.contains(bonusNumber)) {
            throw new InvalidLottoNumberException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getLabeledErrorMessage());
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
