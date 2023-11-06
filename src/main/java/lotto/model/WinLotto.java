package lotto.model;

public class WinLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

}
