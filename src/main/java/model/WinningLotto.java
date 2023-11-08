package model;

import java.util.List;

public class WinningLotto extends Lotto {

    private static final int MIN_BONUS_NUMBER_LENGTH = 1;
    private static final int MAX_BONUS_NUMBER_LENGTH = 2;
    private static final int FIRST_PRIZE = 7;
    private static final int SECOND_PRIZE = 6;
    private static final int THIRD_PRIZE = 5;
    private static  final int FOURTH_PRIZE = 4;
    private static final int FIFTH_PRIZE = 3;

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
            throw new IllegalArgumentException();
        }
    }

    void validateBonusNumberNumeric(String bonusNumberInput) {
        if (!Character.isDigit(bonusNumberInput.charAt(0))) {
            throw new IllegalArgumentException();
        }
    }

    void validateBonusNumberDuplication(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
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
        if (duplicatedNumbersCount == 3)
            return FIFTH_PRIZE;
        if (duplicatedNumbersCount == 4)
            return FOURTH_PRIZE;
        if (duplicatedNumbersCount == 5) {
            if (lotto.contains(bonusNumber)) {
                return SECOND_PRIZE;
            }
            return THIRD_PRIZE;
        }
        if (duplicatedNumbersCount == 6) {
            return FIRST_PRIZE;
        }
        return 0;
    }
}
