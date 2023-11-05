package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

public class LottoGame {
    LottoNumbers lottoNumbers;
    Lotto lotto;

    public LottoGame() {
        lottoNumbers = new LottoNumbers();
        lotto = new Lotto(lottoNumbers.numbers);
    }
}
