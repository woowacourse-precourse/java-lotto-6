package lotto.domain;

public class WinningLotto {

    private Lotto lotto;
    public LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
