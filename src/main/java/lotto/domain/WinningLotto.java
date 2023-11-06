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

    public Lotto toLotto() {
        return lotto;
    }

    public BonusNumber toBonusNumber() {
        return bonusNumber;
    }
    // lotto와 bonusNumber에 중복된 값이  있는지 확인
}
