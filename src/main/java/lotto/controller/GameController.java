package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoPurchaseManager lottoPurchaseManager;
    private LottoResultGenerator lottoResultGenerator;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeLottoPurchaseManager();
        displayPurchasedLottos();
        initializeLottoResultGenerator();
        printResult();
    }

    private void initializeLottoPurchaseManager() {
        LottoPurchaseAmount lottoPurchaseAmount = readPurchaseAmountFromUser();
        lottoPurchaseManager = LottoPurchaseManager.create(lottoPurchaseAmount);
    }

    private LottoPurchaseAmount readPurchaseAmountFromUser() {
        while (true) {
            try {
                String purchaseAmountInput = inputView.printAskPurchaseAmount();
                return LottoPurchaseAmount.create(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayPurchasedLottos() {
        printPurchasedLottos(lottoPurchaseManager.getLottos());
    }

    private void initializeLottoResultGenerator() {
        WinningLotto winningLotto = createWinningLotto();
        lottoResultGenerator = LottoResultGenerator.create(winningLotto, lottoPurchaseManager.getPurchaseAmount());
    }

    private void printResult() {
        Map<PrizeCondition, Long> prizeResult = lottoResultGenerator.generatePrizeResult(lottoPurchaseManager.getLottos());
        double profit = lottoResultGenerator.generateProfit();
        outputView.printResult(prizeResult, profit);
    }

    private void printPurchasedLottos(Lottos lottos) {
        outputView.printLottos(lottos);
    }

    private WinningLotto createWinningLotto() {
        WinningNumbers winningNumbers = createWinningNumbers();
        while (true) {
            try {
                BonusNumber bonusNumber = createBonusNumber();
                return WinningLotto.create(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers createWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = inputView.printAskWinningNumbers();
                return WinningNumbers.create(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber() {
        while (true) {
            try {
                String bonusNumberInput = inputView.printAskBonusNumber();
                return BonusNumber.create(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
