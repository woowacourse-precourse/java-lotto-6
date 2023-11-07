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
        setPurchaseAmount();
        setLotteries();
        setWinningNumbers();
        setBonusNumber();
        showResult();
    }

    private void setPurchaseAmount() {
        String amountInput = lottoView.requestInput(InputRequestMessage.PURCHASE_AMOUNT);
        try {
            String resultOutput = lottoService.createPurchaseAmount(amountInput);
            lottoView.printOutput(resultOutput);
        } catch (IllegalArgumentException illegalArgumentException) {
            lottoView.printError(ErrorMessage.PURCHASE_AMOUNT);
            setPurchaseAmount();
        }
    }

    private void setLotteries() {
        String lottoOutput = lottoService.generateByQuantity();
        lottoView.printOutput(lottoOutput);
    }
}
