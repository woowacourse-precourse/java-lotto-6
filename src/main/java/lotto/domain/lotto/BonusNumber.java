package lotto.domain.lotto;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean checkLottoContainBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }
}
