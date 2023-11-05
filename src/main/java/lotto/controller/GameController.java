package lotto.controller;

import lotto.service.PlayerService;

public class GameController {

    private PlayerService playerService;
    private final int lottoCount;

    public GameController(PlayerService playerService, int lottoCount) {
        this.playerService = playerService;
        this.lottoCount = lottoCount;
    }

    public void start(){
        playerService.buy(lottoCount);
        playerService.check();
    }
}
