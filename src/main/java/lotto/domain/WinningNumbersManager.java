package lotto.domain;

import java.util.List;

public class WinningNumbersManager {
    private static final String BONUS_NUMBER_NOT_OVERLAP_WITH_WINNING_NUMBERS = "보너스 번호는 당첨 번호와 중복되면 안됩니다";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    void inputWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void validateBonusNumber(Integer invalidBonusNumber) {
        for (Integer number : winningNumbers) {
            if (number.equals(invalidBonusNumber)) {
                throw new IllegalArgumentException(BONUS_NUMBER_NOT_OVERLAP_WITH_WINNING_NUMBERS);
            }
        }
    }

    public void inputBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
