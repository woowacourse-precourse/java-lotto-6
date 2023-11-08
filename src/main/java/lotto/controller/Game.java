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

    public void start() {
        outputView.printInputMoneyMessage();
        Money money = new Money(inputView.readMoney());
        player.generateLottos(money);

        outputView.printBoughtLottos(player.getLottos(), player.getCount());
        outputView.printInputWinningNumberMessage();
        WinningNumber winningNumber = new WinningNumber(inputView.readWinningNumbers());

        outputView.printInputBonusNumberMessage();
        winningNumber.setBonusNumber(inputView.readBonusNumber());

        Referee referee = new Referee(winningNumber);
        WinningResult winningResult = referee.judgeRanks(player.getLottos());
        outputView.printStatistics(winningResult.getFormattedStatistics(),
            winningResult.getFormattedProfit(money.value()));
    }
}
