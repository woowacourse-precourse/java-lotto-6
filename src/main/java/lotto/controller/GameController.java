package lotto.controller;

import lotto.domain.Player;
import lotto.service.PlayerService;
import lotto.service.WinningNumberGenerator;
import lotto.util.LottoValues;

public class GameController {

    private Player player;
    private PlayerService playerService;
    private WinningNumberGenerator winningNumberGenerator;
    private OutputController outputController;
    private int lottoCount;
    private int customerPrice;

    public GameController(Player player, PlayerService playerService,WinningNumberGenerator winningNumberGenerator, OutputController outputController) {
        this.player = player;
        this.playerService = playerService;
        this.winningNumberGenerator = winningNumberGenerator;
        this.outputController = outputController;
    }

    public void start(){
        lottoCount = getLottoCount();
        playerService.buy(lottoCount);
        outputController.printLottoPapers(player.getLottoPapers());

        playerService.check(winningNumberGenerator.generate());
        outputController.printWinningStatistics(customerPrice);
    }

    private int getLottoCount() {
        customerPrice = InputController.inputPrice();

        return customerPrice/ LottoValues.LOTTO_PRICE;
    }
}
