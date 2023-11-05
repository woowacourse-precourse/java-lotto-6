package Model;

import java.util.List;

public class WinningLotto extends Lotto {

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
        if (bonusNumber.length() != 1) {
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
