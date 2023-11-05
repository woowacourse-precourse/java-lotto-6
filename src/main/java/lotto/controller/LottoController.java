package lotto.controller;

import lotto.service.LottoService;
import lotto.view.ErrorMessage;
import lotto.view.InputRequestMessage;
import lotto.view.LottoView;

public class LottoController {
    private LottoService lottoService;
    private LottoView lottoView;

    public LottoController() {
        lottoService = new LottoService();
        lottoView = new LottoView();
    }

    public void execute() {
        purchaseLotteries();
    }

    private void purchaseLotteries() {
        String inputAmount = lottoView.requestInput(InputRequestMessage.PURCHASE_AMOUNT);
        try {
            lottoService.generateLotteries(inputAmount);
        } catch (IllegalArgumentException illegalArgumentException) {
            lottoView.printError(ErrorMessage.PURCHASE_AMOUNT);
            purchaseLotteries();
        }
    }
}
