package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = new Lotto(winningNumber);
        validateDuplicate(winningNumber, bonusNumber);
        validateNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<Integer> winningNumber, int bonusNumber) {
        Set<Integer> validateDuplicateWinningNumber = new HashSet<>();
        validateDuplicateWinningNumber.add(bonusNumber);
        for (int number : winningNumber) {
            if (!validateDuplicateWinningNumber.add(number)) {
                throw new IllegalArgumentException("당첨번호와 보너스 번호가 중복됩니다.");
            }
        }
    }

    private int validateNumberInRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException("숫자는 1부터 45 사이의 숫자여야 합니다.");
        }
        return number;
    }
}
