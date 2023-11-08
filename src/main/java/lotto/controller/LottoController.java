package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistic;
import lotto.io.input.InputManager;
import lotto.io.output.OutputView;
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
        readBonusNumber(winningLotto);
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

    private void readBonusNumber(WinningLotto winningLotto) {
        Supplier<Void> supplier = () -> {
            outputView.printBonusNumberRequset();
            winningLotto.updateBonusNumber(inputManager.readBonusNumber().toValue());
            return null;
        };
        retryUntilSuccess(supplier);
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


