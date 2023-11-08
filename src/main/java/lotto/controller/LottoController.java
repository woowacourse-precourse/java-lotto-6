package lotto.controller;

import lotto.domain.amount.PurchaseAmount;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.Lottos;
import lotto.dto.LottosResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = LottoMachine.initial();
    }

    public void run() {
        PurchaseAmount purchaseAmount = receivePurchaseAmount();
        Lottos lottos = lottoMachine.purchaseLottos(purchaseAmount);

        OutputView.printLottoCount(lottos.size());
        OutputView.printLottos(LottosResponse.from(lottos));
    }

    private PurchaseAmount receivePurchaseAmount() {
        try {
            int amount = InputView.readPurchaseAmount();
            return PurchaseAmount.from(amount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return receivePurchaseAmount();
        }
    }
}
