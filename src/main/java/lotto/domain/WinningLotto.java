package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        validateNoDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNoDuplicate(BonusNumber bonusNumber) {
        if (isDuplicateWinningLottoNumberAndBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    private boolean isDuplicateWinningLottoNumberAndBonusNumber(BonusNumber bonusNumber) {
        return winningLotto.LottoContainsNumber(bonusNumber.getBonusNumber());
    }
}
