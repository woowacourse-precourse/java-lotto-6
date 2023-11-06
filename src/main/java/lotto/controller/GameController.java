package lotto.controller;

import lotto.service.PlayerService;
import lotto.service.WinningNumberGenerator;

public class GameController {

    private PlayerService playerService;
    private WinningNumberGenerator winningNumberGenerator;
    private final int lottoCount;

    public GameController(PlayerService playerService,WinningNumberGenerator winningNumberGenerator, int lottoCount) {
        this.playerService = playerService;
        this.winningNumberGenerator = winningNumberGenerator;
        this.lottoCount = lottoCount;
    }

    public void start(){
        playerService.buy(lottoCount);
        playerService.check(winningNumberGenerator.generate());
    }
}
