package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.winning.WinningResult;
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
        purchaseLottos();
        handleWinningStatistics();
    }

    private void purchaseLottos() {
        int purchaseMoney = inputView.readPurchaseMoney();
        List<List<Integer>> lottos = gameService.purchaseLottos(purchaseMoney);

        outputView.printLottos(lottos);
    }

    private void handleWinningStatistics() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();

        Map<WinningResult, Integer> statistics = gameService.determineWinningStatistics(winningNumbers, bonusNumber);
        outputView.printStatistics(statistics);
    }
}
