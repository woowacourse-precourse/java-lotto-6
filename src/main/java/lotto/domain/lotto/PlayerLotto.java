package lotto.domain.lotto;

public class PlayerLotto {

    private Lotto lotto;
    private LottoNumber bonusNumber;

    private PlayerLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static PlayerLotto create(Lotto lotto, LottoNumber bonusNumber) {
        return new PlayerLotto(lotto, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber.getPrimitiveLottoNumber();
    }
}
