package lotto.model;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusLottoNumber) {
        this.lotto = new Lotto(lottoNumbers);
        this.bonusLottoNumber = new LottoNumber(bonusLottoNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
