package lotto.domain.lotto;

public class WinningLotto {
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, BonusNumber bonusNumber) {
        if(lotto.hasSameNumber(bonusNumber)) {
            throw new IllegalArgumentException("ERROR");
        }
    }

}
