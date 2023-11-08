package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private long money;
    public LottoController() {
        buyLotto();
    }

    private void buyLotto() {
        money = InputView.getMoney();
        LottoGenerator generator = new LottoGenerator(money);
        OutputView.printLottos(generator.getLottoCount());
    }
}
