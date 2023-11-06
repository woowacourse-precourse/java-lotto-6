package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void playLotto() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        try {
            String inputAmount = InputView.receivePurchaseAmount();
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);

            PurchasedLottos purchasedLottos = lottoService.getPurchasedLottos(purchaseAmount);

            OutputView.printPurchaseLottoCounts(purchaseAmount);
            OutputView.printRandomLottoNumbers(purchasedLottos);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            purchaseLotto();
        }
    }
}
