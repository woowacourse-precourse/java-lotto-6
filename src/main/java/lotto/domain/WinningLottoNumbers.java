package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {
    private static final String INVALID_BONUS_NUMBER_DUPLICATE_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumberDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumberDuplicate(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }
}