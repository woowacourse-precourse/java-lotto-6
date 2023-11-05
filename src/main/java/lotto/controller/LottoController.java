package lotto.controller;

import lotto.view.LottoInputView;
import lotto.view.View;

public class LottoController implements Controller {
    private final LottoInputView lottoInputView;

    LottoController(View lottoInputView) {
        this.lottoInputView = (LottoInputView) lottoInputView;
    }

    public void programStart() {

    }
}
