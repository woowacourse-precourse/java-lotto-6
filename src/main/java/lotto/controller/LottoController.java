package lotto.controller;

import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoCounter;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LottoController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        LottoService service = new LottoService(readPurchaseAmount());
        outputView.printLottoesNumber(service.getLottoes());
        service.calculateRanking(readWinningLotto());
        outputView.printResult(service.getResult());
        outputView.printProfit(service.getProfit());
    }

    private LottoCounter readPurchaseAmount() {
        return attemptedRead(() -> {
            outputView.printPurchaseMessage();
            LottoCounter counter = inputView.readPurchaseAmount();
            outputView.printNewLine();
            outputView.printTicketCount(counter);
            return counter;
        });
    }

    private WinningLotto readWinningLotto() {
        return attemptedRead(() -> new WinningLotto(readWinningNumber(), readBonusNumber()));
    }

    private Lotto readWinningNumber() {
        return attemptedRead(() -> {
            outputView.printWinningNumberMessage();
            Lotto winningLotto = inputView.readWinningNumber();
            outputView.printNewLine();
            return winningLotto;
        });
    }

    private BonusNumber readBonusNumber() {
        return attemptedRead(() -> {
            outputView.printBonusNumber();
            BonusNumber bonusNumber = inputView.readBonusNumber();
            outputView.printNewLine();
            return bonusNumber;
        });
    }

    private <T> T attemptedRead(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            outputView.printNewLine();
            return supplier.get();
        }
    }
}
