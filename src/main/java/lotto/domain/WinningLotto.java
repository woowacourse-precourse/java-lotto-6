package lotto.domain;

import java.util.List;

import static lotto.domain.Constant.*;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers) {
        validateWinningNumber(winningNumbers);
        validateWinningNumberInRange(winningNumbers);
        this.bonusNumber = 0;
        this.winningNumber = new Lotto(winningNumbers);
    }

    private void validateDuplicateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6자리 입니다.");
        }
    }

    private void validateWinningNumberInRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다.");
            }
        }
    }

}
