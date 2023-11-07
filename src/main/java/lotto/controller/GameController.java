package lotto.controller;

import lotto.service.GameService;
import lotto.view.InputView;

public class GameController {
    private final InputView inputView;
    private final GameService gameService;

    public GameController(InputView inputView, GameService gameService) {
        this.inputView = inputView;
        this.gameService = gameService;
    }

    public void startGame() {
        int purchaseMoney = inputView.readPurchaseMoney();
        gameService.purchaseLottos(purchaseMoney);
    }
}
