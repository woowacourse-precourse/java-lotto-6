package lotto.controller;

import lotto.dto.PurchaseResult;
import lotto.model.Lottos;
import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Purchase purchase = lottoPurchaeByMoney(Integer.parseInt(inputView.inputMoney()));
    }

    private Purchase lottoPurchaeByMoney(Integer money) {
        Lottos lottos = new Lottos();
        Purchase purchase = Purchase.purchase(lottos, money);

        PurchaseResult result = new PurchaseResult(purchase.getLottos(), purchase.getAvailableLotto());
        outputView.outputPurchaseLottos(result);
        return purchase;
    }

}
