package lotto.controller;

import lotto.service.LottoService;
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
            lottoView.printError(illegalArgumentException);
            setPurchaseAmount();
        }
    }

    private void setLotteries() {
        String lottoOutput = lottoService.createLotteries();
        lottoView.printOutput(lottoOutput);
    }

    private void setWinningNumbers() {
        String numbersInput = lottoView.requestInput(InputRequestMessage.WINNIG_NUMBERS);
        try {
            lottoService.createWinningNumbers(numbersInput);
        } catch (IllegalArgumentException illegalArgumentException) {
            lottoView.printError(illegalArgumentException);
            setWinningNumbers();
        }
    }
}
