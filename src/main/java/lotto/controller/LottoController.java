package lotto.controller;

import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoCounter;
import lotto.domain.Lottoes;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        LottoCounter counter = readPurchaseAmount();
        Lottoes lottoes = new Lottoes(counter.getTicketCount());
        outputView.printLottoesNumber(lottoes);
        Lotto winningLotto = readWinningNumber();
        BonusNumber bonusNumber = readBonusNumber();
    }

    private LottoCounter readPurchaseAmount() {
        outputView.printPurchaseMessage();
        LottoCounter counter = inputView.readPurchaseAmount();
        outputView.printNewLine();
        outputView.printTicketCount(counter);
        return counter;
    }

    private Lotto readWinningNumber() {
        outputView.printWinningNumberMessage();
        Lotto winningLotto = inputView.readWinningNumber();
        outputView.printNewLine();
        return winningLotto;
    }

    private BonusNumber readBonusNumber() {
        outputView.printBonusNumber();
        BonusNumber bonusNumber = inputView.readBonusNumber();
        outputView.printNewLine();
        return bonusNumber;
    }
}
