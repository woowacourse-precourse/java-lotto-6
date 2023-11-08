package model;

import java.util.List;
import exception.Exception;
import exception.ExceptionMessage;

public class WinningLotto extends Lotto {

    protected static final int MIN_BONUS_NUMBER_LENGTH = 1;
    protected static final int MAX_BONUS_NUMBER_LENGTH = 2;
    public static final int FIRST_PRIZE = 7;
    public static final int SECOND_PRIZE = 6;
    public static final int THIRD_PRIZE = 5;
    public static  final int FOURTH_PRIZE = 4;
    public static final int FIFTH_PRIZE = 3;

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
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            Exception.raiseInvalidBonusNumberRangeMessage();
        }
    }

    boolean equalsBonusNumber(int bonusNumber) {
        return bonusNumber == this.bonusNumber;
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
