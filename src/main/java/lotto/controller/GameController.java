package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;
import lotto.service.GameService;
import lotto.view.GameOutputView;

import java.util.List;

public class GameController {
    private final GameService gameService;
    private final GameOutputView gameOutputView;

    public GameController(GameService gameService, GameOutputView gameOutputView) {
        this.gameService = gameService;
        this.gameOutputView = gameOutputView;
    }

    public void startGame() {
        List<Lotto> lottos = gameService.getLottos();
        gameOutputView.showLottos(lottos);

        List<Integer> winningNumbers = gameService.getWinningNumbers();
        int bonusBall = gameService.getBonusBall(winningNumbers);

        WinningStatistics winningStatistics = gameService.getWinningStatistics(lottos, winningNumbers, bonusBall);
        gameOutputView.showWinningStatistics(winningStatistics);
    }
}
