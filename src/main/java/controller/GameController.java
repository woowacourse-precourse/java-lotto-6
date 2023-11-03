package controller;

import service.LottoService;

import view.GameView;

public class GameController {

    private final LottoService lottoService;
    private final GameView gameView;

    public GameController(LottoService lottoService, GameView gameView) {
        this.lottoService = lottoService;
        this.gameView = gameView;
    }
}
