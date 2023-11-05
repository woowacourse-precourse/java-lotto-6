package lotto.controller;

import lotto.domain.Buy;
import lotto.view.View;

public class LottoController {
    public void startLotto() {
        buyLotto();
    }

    private void buyLotto() {
        View view = new View();
        Buy buy = new Buy(view.buyPrice());
        view.buyTicketCount(buy.getBuy());
    }
}
