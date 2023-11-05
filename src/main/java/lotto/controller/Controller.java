package lotto.controller;

import lotto.view.View;

public interface Controller {
    static Controller generateLottoController() {
        return new LottoController(View.generateLottoInputView());
    }

    void programStart();
}
