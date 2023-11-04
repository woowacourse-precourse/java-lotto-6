package lotto.controller;

import lotto.view.View;

public class LottoController {
    public void run() {
        issue();
    }

    private void issue() {
        int cost = Integer.parseInt(View.requestCost());
    }
}
