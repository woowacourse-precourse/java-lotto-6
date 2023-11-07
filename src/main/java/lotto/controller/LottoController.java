package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
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
        final Amount amount = readLottoAmount();
        final Lottos lottos = buyLotto(amount);
        WinningLotto winningLotto = readWinningLotto();
        BonusNumber bonusNumber = readBonusNumber();
        winningLotto.updateBonusNumber(bonusNumber.toValue());
        WinningStatistic winningStatistic = lottoService.compareLotto(lottos, winningLotto);
        printResult(amount, winningStatistic);
    }

    private void printResult(Amount amount, WinningStatistic winningStatistic) {
        outputView.printResultLotto(winningStatistic);
        String profit = lottoService.getPerformance(winningStatistic, amount);
        outputView.printProfit(profit);
    }

    private BonusNumber readBonusNumber() {
        return retryUntilSuccess(() -> {
            outputView.printBonusNumberRequset();
            return inputManager.readBonusNumber();
        });

    }

    private WinningLotto readWinningLotto() {
        return retryUntilSuccess(() -> {
            outputView.printWinningLottoRequset();
            return inputManager.readWinningLotto();
        });
    }

    private Lottos buyLotto(Amount amount) {
        final Ticket ticket = lottoService.calculateTicketFromAmonut(amount);
        outputView.printNumberOfTicket(ticket);
        final Lottos lottos = lottoService.saveLottos(ticket);
        outputView.printNumberOfLottos(lottos);
        return lottos;
    }

    private Amount readLottoAmount() {
        return retryUntilSuccess(() -> {
            outputView.printPurchaseAmountRequset();
            return inputManager.readPurchaseAmount();
        });
    }

    private <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }
}


