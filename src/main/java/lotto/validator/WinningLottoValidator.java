package lotto.validator;

import lotto.domain.Lotto;

public class WinningLottoValidator {
    private boolean isNotInRange(int bonusNum) {
        return bonusNum < 1 || bonusNum > 45;
    }

    public void checkRange(int bonusNum) {
        if (isNotInRange(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isDuplicateWinningNumbers(Lotto winLotto, int bonusNum){
        return winLotto.hasSameNumber(bonusNum);
    }

    public void checkDuplicateWinningNumbers(Lotto winLotto, int bonusNum){
        if (isDuplicateWinningNumbers(winLotto, bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 겹칩니다.");
        }
    }
}
