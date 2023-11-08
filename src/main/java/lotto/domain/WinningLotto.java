package lotto.domain;

import java.util.List;

import static lotto.domain.Constant.*;

public class WinningLotto {
    private Lotto winningNumber;

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers) {
        validateWinningNumber(winningNumbers);
        validateWinningNumberInRange(winningNumbers);
        this.bonusNumber = 0;
        this.winningNumber = new Lotto(winningNumbers);
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

    public void setBonusNumber(int bonusNumber) {
        validateDuplicateBonusNumber(bonusNumber);
        validateBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber > MAX_LOTTO_NUMBER || bonusNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1 ~ 45 입니다.");
        }
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값은 입력 불가합니다.");
        }
    }
}
