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
        generateLotteries();
    }

    private void purchaseLotteries() {
        String amountInput = lottoView.requestInput(InputRequestMessage.PURCHASE_AMOUNT);
        try {
            String resultOutput = lottoService.setPurchaseAmount(amountInput);
            lottoView.printOutput(resultOutput);
        } catch (IllegalArgumentException illegalArgumentException) {
            lottoView.printError(ErrorMessage.PURCHASE_AMOUNT);
            purchaseLotteries();
        }
    }

    private void generateLotteries() {
        String lottoOutput = lottoService.generateByQuantity();
        lottoView.printOutput(lottoOutput);
    }
}
