package lotto.controller;

import lotto.view.View;

public class LottoController {

    private View view;

    public LottoController(View view) {
        this.view = view;
    }

    public void run() {
        view.getMoney();
    }
}
