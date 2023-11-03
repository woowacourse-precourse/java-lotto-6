package lotto.controller;

import lotto.view.LottoView;

public class LottoController {
    private LottoView lottoView;

    public LottoController() {
        lottoView = new LottoView();
    }

    public void startLotto() {
        int money = lottoView.inputMoney();
    }

}
