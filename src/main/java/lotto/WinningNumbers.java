package lotto;

import static lotto.utils.validator.ErrorMessageConstants.DUPLICATE_ERROR;
import static lotto.utils.validator.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.validator.ErrorMessageConstants.RANGE_ERROR;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto mainNumbers, int bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    public Lotto getMainNumbers() {
        return mainNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateBonusNumber(){
        validateDuplicate();
        validateNumberRange();
    }

    private void validateNumberRange() {
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD+RANGE_ERROR);
        }
    }

    private void validateDuplicate() {
        if(mainNumbers.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD+DUPLICATE_ERROR);
        }
    }

}
