package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistic;
import lotto.io.InputManager;
import lotto.io.OutputView;
import lotto.service.LottoService;

public class LottoController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final LottoService lottoService;

    public LottoController(final OutputView outputView, final InputManager inputManager,
                           final LottoService lottoService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.lottoService = lottoService;
    }

    public void run() {
        final PurchaseAmount purchaseAmount = readLottoAmount();
        final Lottos lottos = buyRandomLotto(purchaseAmount);
        final WinningLotto winningLotto = readWinningLotto();
        final BonusNumber bonusNumber = readBonusNumber();
        winningLotto.updateBonusNumber(bonusNumber.toValue());
        final WinningStatistic winningStatistic = lottoService.compareLotto(lottos, winningLotto);
        printResult(purchaseAmount, winningStatistic);
    }

    private PurchaseAmount readLottoAmount() {
        return retryUntilSuccess(() -> {
            outputView.printPurchaseAmountRequset();
            return inputManager.readPurchaseAmount();
        });
    }

    private Lottos buyRandomLotto(final PurchaseAmount purchaseAmount) {
        final Ticket ticket = lottoService.calculateTicketFromAmonut(purchaseAmount);
        outputView.printNumberOfTicket(ticket);
        final Lottos lottos = lottoService.saveLottos(ticket);
        outputView.printNumberOfLottos(lottos);
        return lottos;
    }

    private WinningLotto readWinningLotto() {
        return retryUntilSuccess(() -> {
            outputView.printWinningLottoRequset();
            return inputManager.readWinningLotto();
        });
    }

    private BonusNumber readBonusNumber() {
        return retryUntilSuccess(() -> {
            outputView.printBonusNumberRequset();
            return inputManager.readBonusNumber();
        });
    }

    private void printResult(final PurchaseAmount purchaseAmount, final WinningStatistic winningStatistic) {
        outputView.printResultLotto(winningStatistic);
        final String prize = lottoService.getPerformance(winningStatistic, purchaseAmount);
        outputView.printTotalPrize(prize);
    }

    private <T> T retryUntilSuccess(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }
}


