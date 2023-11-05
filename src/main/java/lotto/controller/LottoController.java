package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchasePrice;
import lotto.domain.WinningLotto;
import lotto.io.InputManager;
import lotto.io.OutputView;
import lotto.service.LottoService;

public class LottoController {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputManager inputManager, OutputView outputView, LottoService lottoService) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        purchaseLottos();
        inputWinningLotto();
        resultLottoStatistics();
    }

    private void purchaseLottos() {
        outputView.printLottoPurchasePriceMessage();
        LottoPurchasePrice lottoPurchasePrice = inputManager.inputLottoPurchasePrice();

        lottoService.saveLottos(lottoPurchasePrice);
        outputView.printLottoResult(lottoService.getLottos());
    }

    private void inputWinningLotto() {
        outputView.printWinningNumbers();
        Lotto lotto = inputManager.inputWinningNumbers();

        outputView.printBonusNumber();
        BonusNumber bonusNumber = inputManager.inputBonusNumber(lotto);

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        lottoService.saveWinningLotto(winningLotto);
    }

    private void resultLottoStatistics() {
        outputView.printWinningStatistics();
        lottoService.calculateWinningStatistics();
        outputView.printLottoStaticsResult(lottoService.getStatistics());
    }
}
