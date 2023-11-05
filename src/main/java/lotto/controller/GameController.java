package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

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
        winningNumbers.assignBonusNumber(bonusNumber);

        long inputMoney = lottoPurchaseManager.getInputMoney();

        LottoResultGenerator lottoResultGenerator = LottoResultGenerator.create(winningNumbers, bonusNumber, inputMoney);
        Map<PrizeCondition, Long> prizeResult = lottoResultGenerator.generatePrizeResult(lottos);
        double profit = lottoResultGenerator.generateProfit();
        outputView.printResult(prizeResult, profit);
    }

    private void initializeLottoPurchaseManager() {
        lottoPurchaseManager = new LottoPurchaseManager(new LottoGenerator());
    }

    private void printLottos(Lottos lottos) {
        outputView.printLottos(lottos);
    }
}
