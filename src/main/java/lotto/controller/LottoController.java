package lotto.controller;

import lotto.model.Lottos;
import lotto.view.View;

public class LottoController {
    public void run() {
        issue();
    }

    private void issue() {
        int cost = Integer.parseInt(View.requestCost());
        Lottos lottos = Lottos.from(getCountFrom(cost));
    }

    private int getCountFrom(int cost) {
        return cost / 1000;
    }
}
