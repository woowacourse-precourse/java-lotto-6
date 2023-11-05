package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> winningNumber = lotto.getNumbers();
        if (isWrongRange(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자가 입력 되어야 합니다.");
        }

        if (isContainInLotto(winningNumber, bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복 될 수 없습니다.");
        }
    }

    private boolean isWrongRange(int bonusNumber) {
        return bonusNumber < 1 || bonusNumber > 45;
    }

    private boolean isContainInLotto(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public Lotto getWinningNumber() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
