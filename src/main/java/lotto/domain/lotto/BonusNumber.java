package lotto.domain.lotto;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        verifyRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private void verifyRange(int bonusNumber) {
        if (bonusNumber < Lotto.MIN_NUMBER || bonusNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 숫자는 1에서 45 사이에 있어야 합니다.");
        }
    }

    public boolean isMatching(Lotto lotto) {
        List<Integer> winningNumbers = lotto.getNumbers();
        return winningNumbers.contains(bonusNumber);
    }
}
