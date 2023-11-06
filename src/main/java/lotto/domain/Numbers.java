package lotto.domain;

import lotto.type.ErrorCode;

import java.util.List;

public class Numbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Numbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumber(winningNumbers);
        checkDuplicationWinningNumber(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    void validateWinningNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    void checkDuplicationWinningNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    void validateBonusNumber(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER.getDescription());
        }
    }

}
