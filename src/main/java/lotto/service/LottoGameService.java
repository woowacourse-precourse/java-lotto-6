package lotto.service;

import java.util.List;
import lotto.model.Player;
import lotto.model.WinningNumbers;
import lotto.util.RandomUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameService {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomUtil randomUtil;

    public LottoGameService(InputView inputView, OutputView outputView, RandomUtil randomUtil) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomUtil = randomUtil;
    }

    public Player createPlayer() {
        outputView.requestPaymentAmount();
        int paymentAmount = inputView.purchaseCost();
        outputView.printLineOfSpace();
        return new Player(paymentAmount, randomUtil);
    }

    public WinningNumbers createWinningNumber() {
        outputView.requestWinningNumber();
        List<Integer> winningNumbers = inputView.winningNumber();
        outputView.printLineOfSpace();
        outputView.requestBonusNumber();
        int bonusNumber = inputView.bonusNumber(winningNumbers);
        outputView.printLineOfSpace();

        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}