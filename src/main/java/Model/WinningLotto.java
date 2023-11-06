package Model;

import java.util.List;

public class WinningLotto extends Lotto {

    private static final int MIN_BONUS_NUMBER_LENGTH = 1;
    private static final int MAX_BONUS_NUMBER_LENGTH = 2;

    int bonusNumber;

    public WinningLotto(String WinningNumbers, String bonusNumber) {
        super(WinningNumbers);
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
}
