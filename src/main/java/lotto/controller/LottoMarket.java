package lotto.controller;

import lotto.domain.Money;
import lotto.service.LottoMarketService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMarket {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void enter() {
        outputView.printInputMoneyMessage();
        Money money = inputView.readMoneyToBuyLotto();
        buy(money);
    }

    private void buy(Money money) {
        LottoMarketService service = new LottoMarketService(money);
        outputView.printPurchasedLottoCount(service.getPurchasedCount());
    }
}
