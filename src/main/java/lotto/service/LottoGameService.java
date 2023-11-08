package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Player;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;
import lotto.util.RandomUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    private final OutputView outputView;
    private final RandomUtil randomUtil;

    public LottoGameService(OutputView outputView, RandomUtil randomUtil) {
        this.outputView = outputView;
        this.randomUtil = randomUtil;
    }

    public Player createPlayer() {
        outputView.requestPaymentAmount();
        return InputView.commonInput(() -> new Player(InputView.paymentAmount(), randomUtil));
    }

    public WinningNumbers createWinningNumber() {
        outputView.requestWinningNumber();
        WinningNumber winningNumber = InputView.commonInput(() -> new WinningNumber(InputView.winningNumber()));
        outputView.printLineOfSpace();
        outputView.requestBonusNumber();
        BonusNumber bonusNumber = InputView.commonInput(
                () -> new BonusNumber(InputView.bonusNumber(), winningNumber.getNumbers()));
        outputView.printLineOfSpace();

        return new WinningNumbers(winningNumber.getNumbers().stream().mapToInt(Integer::valueOf).toArray(),
                bonusNumber.getNumber());
    }
}