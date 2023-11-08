package lotto.controller;

import lotto.domain.Player;
import lotto.service.LottoCountGenerator;
import lotto.service.PlayerService;
import lotto.service.WinningNumberGenerator;

public class GameController {

    private Player player;
    private PlayerService playerService;
    private WinningNumberGenerator winningNumberGenerator;
    private OutputController outputController;
    private LottoCountGenerator lottoCountGenerator;

    public GameController(Player player, PlayerService playerService, WinningNumberGenerator winningNumberGenerator,
                          OutputController outputController, LottoCountGenerator lottoCountGenerator) {
        this.player = player;
        this.playerService = playerService;
        this.winningNumberGenerator = winningNumberGenerator;
        this.outputController = outputController;
        this.lottoCountGenerator = lottoCountGenerator;
    }

    public void start() {
        int customerPrice = lottoCountGenerator.getCustomerPrice();
        int lottoCount = lottoCountGenerator.getLottoCount(customerPrice);

        playerService.buy(lottoCount);
        outputController.printLottoPapers(player.getLottoPapers());

        playerService.check(winningNumberGenerator.generate());
        outputController.printWinningStatistics(customerPrice);
    }
}
