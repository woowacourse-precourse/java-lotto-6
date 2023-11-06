package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
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
        receiveWinningLotto();
    }

    private void purchaseLotto() {
        try {
            String inputAmount = InputView.receivePurchaseAmount();
            lottoService.setPurchasedLottos(inputAmount);
            printPurchaseResult();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            purchaseLotto();
        }
    }

    private void printPurchaseResult() {
        OutputView.printPurchaseLottoCounts(lottoService.getPurchaseAmount());
        OutputView.printRandomLottoNumbers(lottoService.getPurchasedLottos());
    }

    private void receiveWinningLotto() {
        try {
            String inputWinningNumbers = InputView.receiveWinningNumber();
            lottoService.setWinningLotto(inputWinningNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            receiveWinningLotto();
        }
    }
}
