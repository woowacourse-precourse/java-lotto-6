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
        String input = lottoView.requestInput(InputRequestMessage.PURCHASE);
        try {
            lottoService.generateLotteries(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            lottoView.printError(ErrorMessage.PURCHASE_AMOUNT);
            purchaseLotteries();
        }
    }
}
