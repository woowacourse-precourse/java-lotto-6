package lotto.controller;

import lotto.domain.*;
import lotto.service.GameManager;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameManager gameManager;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeGameManager();
        printPurchasedLottos();
        processResult();
        printResult();
    }

    private void initializeGameManager() {
        LottoPurchaseAmount lottoPurchaseAmount = readPurchaseAmountFromUser();
        gameManager = GameManager.create(lottoPurchaseAmount);
    }

    private LottoPurchaseAmount readPurchaseAmountFromUser() {
        inputView.printAskPurchaseAmount();
        while (true) {
            try {
                String purchaseAmountInput = inputView.readInputFromUser();
                return LottoPurchaseAmount.create(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPurchasedLottos() {
        Lottos lottos = gameManager.providePurchasedLottos();
        outputView.printLottos(lottos);
    }

    private void processResult() {
        WinningLotto winningLotto = createWinningLotto();
        gameManager.processResult(winningLotto);
    }

    private WinningLotto createWinningLotto() {
        WinningNumbers winningNumbers = readWinningNumbersFromUser();
        inputView.printAskBonusNumber();
        while (true) {
            try {
                String bonusNumberInput = inputView.readInputFromUser();
                return WinningLotto.create(winningNumbers, bonusNumberInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers readWinningNumbersFromUser() {
        inputView.printAskWinningNumbers();
        while (true) {
            try {
                String winningNumbersInput = inputView.readInputFromUser();
                return WinningNumbers.create(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printResult() {
        Map<PrizeCondition, Long> prizeResult = gameManager.providePrizeResult();
        double profit = gameManager.provideProfit();
        outputView.printResult(prizeResult, profit);
    }
}
