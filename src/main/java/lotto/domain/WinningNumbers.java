package lotto.domain;

import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS;
import static lotto.constant.message.ErrorMessage.INVALID_NUMBER_RANGE;

import java.util.List;
import lotto.constant.Prize;

public class WinningNumbers {
    private Lotto winningNumber;
    private int bonusNumber;

    public void makeWinningNumber(List<Integer> numbers) throws IllegalArgumentException {
        this.winningNumber = new Lotto(numbers);
    }

    public void makeBonusNumber(int bonusNumber) throws IllegalArgumentException {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Prize checkPrize(Lotto otherLotto) {
        int count = winningNumber.matchCount(otherLotto);
        boolean bonusMatch = otherLotto.isContain(bonusNumber);
        if (count == 5 && bonusMatch) {
            return Prize.SECOND;
        }
        return Prize.getByMatch(count);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonus(winningNumber, bonusNumber);
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
        if (winningNumber.isContain(bonusNumber)) {
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
