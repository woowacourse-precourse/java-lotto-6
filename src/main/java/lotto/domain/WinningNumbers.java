package lotto.domain;

import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS;
import static lotto.constant.message.ErrorMessage.INVALID_NUMBER_RANGE;

import java.util.List;

public class WinningNumbers {
    private Lotto winningNumber;
    private int bonusNumber;

    public void makeWinningNumber(List<Integer> numbers) throws IllegalArgumentException {
        this.winningNumber = new Lotto(numbers);
    }

    public void makeBonusNumber(int bonusNumber) throws IllegalArgumentException {
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonus(winningNumber, bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (!validRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean validRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private void validateDuplicateBonus(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS.getMessage());
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
