package lotto.model;

public class WinningLotto {
    private final BonusNumber bonusNumber;
    private final Lotto winningLotto;

    public WinningLotto(Lotto lotto, BonusNumber bonus) {
        validateWinningLotto(lotto, bonus);
        winningLotto = lotto;
        bonusNumber = bonus;
    }

    public void validateWinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        isDuplicateWinningLotto(lotto, bonusNumber);
    }

    private void isDuplicateWinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.isContain(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }
}
