package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private static final String NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE = "당첨 번호와 중복된 보너스 번호는 입력할 수 없습니다.";
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        validateDuplicate(winningNumber, bonusNumber);
        this.winningNumber = new WinningNumber(winningNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }
}
