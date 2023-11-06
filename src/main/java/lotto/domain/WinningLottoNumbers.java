package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {
    private static final String INVALID_BONUS_NUMBER_DUPLICATE_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String INVALID_LOTTO_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final int VALID_LOTTO_START_NUMBER = 1;
    private static final int VALID_LOTTO_END_NUMBER = 45;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLottoNumbers(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static void validateNumberRange(int number) {
        if (number < VALID_LOTTO_START_NUMBER || number > VALID_LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    private void validateBonusNumberDuplicate(int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }
}