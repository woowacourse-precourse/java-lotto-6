package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoController {
    public void run(){
        LottoNumber lottoNumber = new LottoNumber();
        Lotto lotto = new Lotto(lottoNumber.getLottoNumbers());
    }
}
