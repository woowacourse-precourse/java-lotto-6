package lotto.controller;

import lotto.service.LottoService;
import lotto.util.Splitter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        initPurchaseAmount();
        purchaseAndDisplayLottos();
        initWinningLotto();
        initWinningNumbers();
        compareNumbersAndDisplayResult();
        displayProfitRate();
    }

    private void purchaseAndDisplayLottos() {
        lottoService.purchaseLotto();
        OutputView.displayLottos(lottoService.getLottoDtos());
    }

    private void compareNumbersAndDisplayResult() {
        lottoService.compareNumbers();
        OutputView.displayResult(lottoService.getLottoResultDto());
    }

    private void displayProfitRate() {
        OutputView.displayProfitRate(lottoService.getProfitRate());
    }

    private void initWinningNumbers() {
        try {
            lottoService.initWinningNumbers(InputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            initWinningNumbers();
        }
    }

    private void initWinningLotto() {
        try {
            lottoService.initWinningLotto(Splitter.splitByComma(InputView.inputWinningLotto()));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            initWinningLotto();
        }
    }

    private void initPurchaseAmount() {
        try {
            lottoService.initPurchaseAmount(InputView.inputPurchaseAmount());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            initPurchaseAmount();
        }
    }

}
