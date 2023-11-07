package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.EarningRate;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.io.InputManager;
import lotto.io.OutputView;
import lotto.service.LottoService;

import java.util.function.Supplier;

public class LottoController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final LottoService lottoService;

    public LottoController(
            final OutputView outputView,
            final InputManager inputManager,
            final LottoService lottoService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.lottoService = lottoService;
    }

    public void run() {
        createPurchaseAmount();
        purchase();
        createWinningCombination();
        calculateWinningResult();
        checkEarningRate();
    }

    private void createPurchaseAmount() {
        outputView.printPurchaseAmountRequest();
        final PurchaseAmount purchaseAmount = read(inputManager::readPurchaseAmount);
        lottoService.savePurchaseAmount(purchaseAmount);
    }

    private void purchase() {
        final Lottos lottos = lottoService.purchase();
        outputView.printLottos(lottos);
    }

    private void createWinningCombination() {
        outputView.printWinningNumbersRequest();
        final WinningNumbers winningNumbers = read(inputManager::readWinningNumbers);

        outputView.printBonusNumberRequest();
        final BonusNumber bonusNumber = read(inputManager::readBonusNumber);

        lottoService.saveWinningCombination(winningNumbers, bonusNumber);
    }

    private void calculateWinningResult() {
        outputView.printResult();
        final WinningResult winningResult = lottoService.calculateWinningResult();
        outputView.printWinningResult(winningResult);
    }

    private void checkEarningRate() {
        final EarningRate earningRate = lottoService.checkEarningRate();
        outputView.printEarningRate(earningRate);
    }

    private <T> T read(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (final IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
