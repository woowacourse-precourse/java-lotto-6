package lotto.model;

import java.util.List;

public class WinningLotto {
    private final String ERROR_DUPLICATE_WINNING_NUMBERS = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.";
    private final BonusNumber bonusNumber;
    private final Lotto winningLotto;

    public WinningLotto(Lotto lotto, BonusNumber bonus) {
        validateWinningLotto(lotto, bonus);
        winningLotto = lotto;
        bonusNumber = bonus;
    }

    private void validateWinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        isDuplicateWinningLotto(lotto, bonusNumber);
    }

    private void isDuplicateWinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.isContain(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBERS);
        }
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getNumbers();
    }
}
