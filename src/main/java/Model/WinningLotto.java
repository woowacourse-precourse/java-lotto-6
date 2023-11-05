package Model;

import java.util.List;

public class WinningLotto extends Lotto {

    int bonusNumber;

    public WinningLotto(String WinningNumbers, String bonusNumber) {
        super(WinningNumbers);
        this.bonusNumber = bonusNumber;
    }

    int validate(String bonusNumberInput) {

        return bonusNumber;
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
