package lotto.controller;

import lotto.domain.Price;
import lotto.view.View;

public class LottoController {
    public void startLotto() {
        buyLotto();
    }

    private void buyLotto() {
        View view = new View();
        view.buyPrice();
    }
}
