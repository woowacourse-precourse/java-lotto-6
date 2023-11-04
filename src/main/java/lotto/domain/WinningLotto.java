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

    // lotto와 bonusNumber에 중복된 값이  있는지 확인
}
