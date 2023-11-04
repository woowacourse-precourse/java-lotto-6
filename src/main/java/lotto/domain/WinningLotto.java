package lotto.domain;

public class WinningLotto {

    private Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void updateBonusNumber(Integer value) {
        this.bonusNumber = new BonusNumber(value);
    }
}
