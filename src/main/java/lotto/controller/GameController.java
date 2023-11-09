package lotto.controller;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.Lottos;
import lotto.domain.PrizeCondition;
import lotto.domain.WinningLotto;
import lotto.dto.PurchasedLottosDto;
import lotto.service.GameManager;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private PurchaseAmountInputHandler purchaseAmountInputHandler;
    private WinningLottoInputHandler winningLottoInputHandler;
    private GameManager gameManager;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initializeInputHandlers();
        initializeGameManager();
        printPurchasedLottos();
        processResult();
        printResult();
    }

    private void initializeInputHandlers() {
        purchaseAmountInputHandler = PurchaseAmountInputHandler.create(inputView, outputView);
        winningLottoInputHandler = WinningLottoInputHandler.create(inputView, outputView);
    }

    private void initializeGameManager() {
        LottoPurchaseAmount lottoPurchaseAmount = readPurchaseAmountFromUser();
        gameManager = GameManager.from(lottoPurchaseAmount);
    }

    private LottoPurchaseAmount readPurchaseAmountFromUser() {
        return purchaseAmountInputHandler.createPurchaseAmount();
    }

    private void printPurchasedLottos() {
        Lottos lottos = gameManager.providePurchasedLottos();
        PurchasedLottosDto purchasedLottosDto = PurchasedLottosDto.from(lottos);
        outputView.printLottos(purchasedLottosDto);
    }

    private void processResult() {
        WinningLotto winningLotto = winningLottoInputHandler.createWinningLotto();
        gameManager.processResult(winningLotto);
    }

    private void printResult() {
        Map<PrizeCondition, Long> prizeResult = gameManager.providePrizeResult();
        double profit = gameManager.provideProfit();
        outputView.printResult(prizeResult, profit);
    }
}
