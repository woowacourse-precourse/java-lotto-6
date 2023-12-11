package lotto.model;

import static lotto.constant.Constant.MAX_LOTTO_NUMBER;
import static lotto.constant.Constant.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorInputException.ErrorMessage.BONUS_NUMBER_CAN_NOT_BE_DUPLICATE;
import static lotto.exception.ErrorInputException.ErrorMessage.BONUS_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE;

import java.util.List;
import lotto.exception.ErrorInputException;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(List<Integer> winnerNumber, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        isDuplicate(winnerNumber);
        isBetweenOneAndFortyFive();
    }

    public boolean isSameBonusNumber(BonusNumber other) {
        return other.bonusNumber == this.bonusNumber;
    }

    public static BonusNumber createBonusNumber(List<Integer> winnerNumber, int bonusNumber) {
        return new BonusNumber(winnerNumber, bonusNumber);
    }

    private void isDuplicate(List<Integer> winnerNumbers) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new ErrorInputException(BONUS_NUMBER_CAN_NOT_BE_DUPLICATE);
        }
    }

    private void isBetweenOneAndFortyFive() {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new ErrorInputException(BONUS_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }
}
