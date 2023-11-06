package lotto.domain;

public class WinLotto {
    private Lotto lottoNumber;
    private int bonusNumber;

    public WinLotto(Lotto lottoNumber, int bonusNumber) {
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }
}
