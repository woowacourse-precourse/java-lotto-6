package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoPurchaseManager lottoPurchaseManager;
    private long inputMoney;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeLottoPurchaseManager();
        Lottos lottos = createLottos();
        inputMoney = lottoPurchaseManager.getInputMoney();
        printPurchasedLottos(lottos);

        WinningLotto winningLotto = createWinningLotto();
        LottoResultGenerator lottoResultGenerator = LottoResultGenerator.create(winningLotto, inputMoney);
        Map<PrizeCondition, Long> prizeResult = lottoResultGenerator.generatePrizeResult(lottos);
        double profit = lottoResultGenerator.generateProfit();
        outputView.printResult(prizeResult, profit);
    }

    private void initializeLottoPurchaseManager() {
        lottoPurchaseManager = new LottoPurchaseManager(new LottoGenerator());
    }

    private Lottos createLottos() {
        while (true) {
            try {
                String purchaseAmountInput = inputView.printAskPurchaseAmount();
                return lottoPurchaseManager.createLottos(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
                System.out.println(e.getMessage());
            }
        }
    }


    private WinningNumbers createWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = inputView.printAskWinningNumbers();
                return WinningNumbers.create(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber createBonusNumber() {
        while (true) {
            try {
                String bonusNumberInput = inputView.printAskBonusNumber();
                return BonusNumber.create(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
