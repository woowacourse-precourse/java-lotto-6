package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.LottoView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final LottoView lottoView;

    public LottoController(LottoMachine lottoMachine, LottoView lottoView) {
        this.lottoMachine = lottoMachine;
        this.lottoView = lottoView;
    }

    public void runMachine() {
        // TODO : lottoView 구현 반영.
        Lotto lotto = lottoMachine.generateLotto();
    }
}
