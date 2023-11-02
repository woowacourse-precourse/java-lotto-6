package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    private final LottoService lottoService;

    public LottoGameController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        lottoPurchase();
        lottoGameInit();
        printLottoResults();
    }

    private void lottoPurchase() {
        String inputPurchaseAmount = getValidInputPurchaseAmount();
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        int purchaseQuantity = purchaseAmount / 1000;
        List<Lotto> userLottos = lottoService.purchase(purchaseQuantity);
        OutputView.quantityAndLottoNumbers(userLottos);
    }

    private String getValidInputPurchaseAmount() {
        while (true) {
            String inputPurchaseAmount = InputView.purchaseAmount();
            try {
                Validator.purchaseAmount(inputPurchaseAmount);
                return inputPurchaseAmount;
            } catch (IllegalArgumentException e) {
                OutputView.errorMessage(e);
            }
        }
    }

    private void lottoGameInit() {
    }

    private void printLottoResults() {
    }
}
