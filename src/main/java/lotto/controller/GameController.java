package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoPurchaseManager lottoPurchaseManager;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeLottoPurchaseManager();
        String purchaseAmountInput = inputView.printAskPurchaseAmount();
        Lottos lottos = lottoPurchaseManager.createLottos(purchaseAmountInput);
        printLottos(lottos);
        String winningNumbersInput = inputView.printAskWinningNumbers();
        WinningNumbers winningNumbers = WinningNumbers.create(winningNumbersInput);
        String bonusNumberInput = inputView.printAskBonusNumber();
        BonusNumber bonusNumber = BonusNumber.create(bonusNumberInput);
        LottoResultCalculator lottoResultCalculator = LottoResultCalculator.create(winningNumbers, bonusNumber);

    }

    private void initializeLottoPurchaseManager() {
        lottoPurchaseManager = new LottoPurchaseManager(new LottoGenerator());
    }

    private void printLottos(Lottos lottos) {
        outputView.printLottos(lottos);
    }
}
