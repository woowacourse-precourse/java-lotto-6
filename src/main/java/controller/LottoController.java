package controller;

import lotto.LottoMoney;
import lotto.LuckeyLotto;

public class LottoController {
    LuckeyLotto luckeyLotto;
    LottoMoney lottoMoney;

    public LottoController(LottoMoney lottoMoney, LuckeyLotto luckeyLotto) {
        this.lottoMoney = lottoMoney;
        this.luckeyLotto = luckeyLotto;
    }
}
