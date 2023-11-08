package lotto.controller;

import lotto.domain.Money;
import lotto.domain.NumberGenerator;
import lotto.domain.Player;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.Referee;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        this.player = new Player(numberGenerator);
    }

    public void run() {
        generateLotto();
        WinningNumber winningNumber = readWinningNumber();
        judge(winningNumber);
    }

    private void generateLotto() {
        while (true) {
            try {
                outputView.printInputMoneyMessage();
                Long money = inputView.readMoney();
                player.generateLottos(new Money(money));
                break;
            } catch (IllegalArgumentException ex) {
                outputView.print(ex.getMessage());
            }
        }
        outputView.printBoughtLottos(player.getLottos(), player.getCount());
    }

    private WinningNumber readWinningNumber() {
        WinningNumber winningNumber = readWinningNumbers();
        readBonusNumber(winningNumber);
        return winningNumber;
    }

    private WinningNumber readWinningNumbers() {
        outputView.printInputWinningNumberMessage();
        while (true) {
            try {
                return new WinningNumber(inputView.readWinningNumbers());
            } catch (IllegalArgumentException ex) {
                outputView.print(ex.getMessage());
            }
        }
    }

    private void readBonusNumber(WinningNumber winningNumber) {
        outputView.printInputBonusNumberMessage();
        while (true) {
            try {
                winningNumber.setBonusNumber(inputView.readBonusNumber());
                return;
            } catch (IllegalArgumentException ex) {
                outputView.print(ex.getMessage());
            }
        }
    }

    private void judge(WinningNumber winningNumber) {
        Referee referee = new Referee(winningNumber);
        WinningResult winningResult = referee.judgeRanks(player.getLottos());
        outputView.printStatistics(winningResult.getFormattedStatistics(),
            winningResult.getFormattedProfit(player.getMoney()));
    }
}
