package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.Player;
import lotto.model.lotto.Winning;
import lotto.model.result.Result;

public class MainController {
    private final PlayerController playerController;
    private final WinningController winningController;
    private final ResultController resultController;

    public MainController() {
        playerController = new PlayerController();
        winningController = new WinningController();
        resultController = new ResultController();
    }

    public void run() {
        Player player = playerController.createPlayer();
        playerController.showPlayerLotto(player);

        Lotto winningLotto = winningController.getWinningLotto();
        Winning winning = winningController.createWinning(winningLotto);

        Result result = resultController.createResult(player, winning);
        resultController.showResult(result, player);
    }
}