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
    private int lottoCount;
    private int customerPrice;

    public GameController(Player player, PlayerService playerService, WinningNumberGenerator winningNumberGenerator,
                          OutputController outputController, LottoCountGenerator lottoCountGenerator) {
        this.player = player;
        this.playerService = playerService;
        this.winningNumberGenerator = winningNumberGenerator;
        this.outputController = outputController;
        this.lottoCountGenerator = lottoCountGenerator;
    }

    public void start() {
        customerPrice = lottoCountGenerator.getCustomerPrice();
        lottoCount = lottoCountGenerator.getLottoCount(customerPrice);

        playerService.buy(lottoCount);
        outputController.printLottoPapers(player.getLottoPapers(), lottoCount);

        playerService.check(winningNumberGenerator.generate());
        outputController.printWinningStatistics(customerPrice);
    }
}
