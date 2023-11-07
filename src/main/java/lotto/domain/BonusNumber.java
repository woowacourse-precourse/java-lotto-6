package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static final String DUPLICATE_WITH_WINNING_NUMBER = "[ERROR] 당첨 번호와 중복되지 않는 값이어야 합니다.";
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, WinningNumber winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusNumberContainedInLottoNumbers(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private void validate(int bonusNumber, WinningNumber winningNumber) {
        if (isDuplicateWithWinningNumber(bonusNumber, winningNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WITH_WINNING_NUMBER);
        }
    }

    private boolean isDuplicateWithWinningNumber(int bonusNumber, WinningNumber winningNumber) {
        return winningNumber.contains(bonusNumber);
    }
}