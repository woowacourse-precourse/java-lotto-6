package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomNumbersGenerator;
import lotto.service.LottoMarketService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMarket {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private Lottos lottos;

    public void enter() {
        outputView.printInputMoneyMessage();
        Money money = inputView.readMoneyToBuyLotto();
        buy(money);
    }

    private void buy(Money money) {
        LottoMarketService service = new LottoMarketService(money, new RandomNumbersGenerator());
        outputView.printPurchasedLottoCount(service.getPurchasedCount());
        lottos = service.makeLottos();
        outputView.printLottos(lottos.getLottos());
        goOut();
    }

    public Lottos goOut() {
        return lottos;
    }
}
