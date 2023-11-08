package lotto.controller;

import java.util.List;
import lotto.domain.Money;
import lotto.domain.winning.WinningStatistics;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void startGame() {
        Money purchaseMoney = new Money(inputView.readPurchaseMoney());
        purchaseLottos(purchaseMoney);
        handleWinningStatistics(purchaseMoney);
    }

    private void purchaseLottos(Money purchaseMoney) {
        List<List<Integer>> lottos = gameService.purchaseLottos(purchaseMoney);
        outputView.printLottos(lottos);
    }

    private void handleWinningStatistics(Money purchaseMoney) {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();

        WinningStatistics statistics = gameService.determineWinningStatistics(winningNumbers, bonusNumber);
        outputView.printStatistics(statistics.getStatistics());
        printRateOfReturn(purchaseMoney, statistics.getTotalWinningMoney());
    }

    private void printRateOfReturn(Money purchaseMoney, Money totalWinningMoney) {
        double rateOfReturn = totalWinningMoney.getRatio(purchaseMoney);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
