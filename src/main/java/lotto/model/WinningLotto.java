package lotto.model;

import static lotto.model.LottoUtils.FIRST_PRIZE;
import static lotto.model.LottoUtils.SECOND_PRIZE;

import lotto.exception.Exception;
import java.util.List;

public class WinningLotto extends Lotto {

    protected static final int MIN_BONUS_NUMBER_LENGTH = 1;
    protected static final int MAX_BONUS_NUMBER_LENGTH = 2;

    int bonusNumber;

    public WinningLotto(String winningNumbers, String bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    public WinningLotto(List<Integer> winningNumbers, String bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    int validateBonusNumber(String bonusNumberInput) {
        validateBonusNumberLength(bonusNumberInput);
        validateBonusNumberNumeric(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(super.getNumbers(),bonusNumber);
        return bonusNumber;
    }

    void validateBonusNumberLength(String bonusNumber) {
        if (bonusNumber.length() > MAX_BONUS_NUMBER_LENGTH || bonusNumber.length() < MIN_BONUS_NUMBER_LENGTH) {
            Exception.raiseInvalidInputException();
        }
    }

    void validateBonusNumberNumeric(String bonusNumberInput) {
        if (!Character.isDigit(bonusNumberInput.charAt(0))) {
            Exception.raiseInvalidBonusNumberArgumentException();
        }
    }

    void validateBonusNumberDuplication(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            Exception.raiseInvalidWinningNumberDuplicationException();
        }
    }

    void validateBonusNumberRange(int bonusNumber) {
        if (LottoUtils.isOutOfLottoRange(bonusNumber)) {
            Exception.raiseInvalidBonusNumberRangeMessage();
        }
    }

    int countContains(Lotto lotto) {
        int duplicatedNumbersCount = 0;
        for (int lottoNumber : lotto.getNumbers()) {
            if (super.getNumbers().contains(lottoNumber)) {
                duplicatedNumbersCount++;
            }
        }
        return duplicatedNumbersCount;
    }

    int judgePrize(Lotto lotto) {
        int duplicatedNumberCount = countContains(lotto);
        if (duplicatedNumberCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
            return SECOND_PRIZE;
        }
        if (duplicatedNumberCount == 6) {
            return FIRST_PRIZE;
        }
        return duplicatedNumberCount;
    }
}
