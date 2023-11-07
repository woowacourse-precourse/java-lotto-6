package lotto.controller;

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
        receiveBonusLotto();
        printResult();
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

    private void receiveBonusLotto() {
        try {
            String inputBonusNumbers = InputView.receiveBonusNumber();
            lottoService.setBonusNumber(inputBonusNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            receiveBonusLotto();
        }
    }

    private void printResult() {
        printWinningStatistics();
        printWinningRate();
    }

    private void printWinningStatistics() {
        lottoService.calculateWinningStatistics();
        OutputView.printWinningStatistics(lottoService.getWinningStatistics());
    }

    private void printWinningRate() {
        OutputView.printWinningRate(lottoService.getWinningRate());
    }
}
