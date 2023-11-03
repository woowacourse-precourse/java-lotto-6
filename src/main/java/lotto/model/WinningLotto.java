package lotto.model;

import static lotto.constant.LottoRuleConstant.LOTTO_MAX_NUM;
import static lotto.constant.LottoRuleConstant.LOTTO_MIN_NUM;

public class WinningLotto {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;

        validateBonusNumber(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        checkRange(bonusNumber);
        checkDuplicateWithWinningNumber(bonusNumber);
    }

    private void checkRange(int bonusNumber) {
        if (checkMinimum(bonusNumber) || checkMaximum(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하의 숫자만 입력이 가능합니다.");
        }
    }

    private boolean checkMinimum(int bonusNumber) {
        return bonusNumber < LOTTO_MIN_NUM;
    }

    private boolean checkMaximum(int bonusNumber) {
        return bonusNumber > LOTTO_MAX_NUM;
    }

    private void checkDuplicateWithWinningNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 다른 1이상 45이하의 숫자만 입력이 가능합니다.");
        }
    }
}
