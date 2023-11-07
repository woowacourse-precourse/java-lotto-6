package lotto.controller;

import lotto.domain.Player;
import lotto.service.PlayerService;
import lotto.service.WinningNumberGenerator;
import lotto.util.ErrorMessage;
import lotto.util.LottoValues;

public class GameController {

    private Player player;
    private PlayerService playerService;
    private WinningNumberGenerator winningNumberGenerator;
    private OutputController outputController;
    private int lottoCount;
    private int customerPrice;

    public GameController(Player player, PlayerService playerService, WinningNumberGenerator winningNumberGenerator,
                          OutputController outputController) {
        this.player = player;
        this.playerService = playerService;
        this.winningNumberGenerator = winningNumberGenerator;
        this.outputController = outputController;
    }

    public void start() {
        inputLottoCount();
        playerService.buy(lottoCount);
        outputController.printLottoPapers(player.getLottoPapers(), lottoCount);

        playerService.check(winningNumberGenerator.generate());
        outputController.printWinningStatistics(customerPrice);
    }

    private void inputLottoCount() {
        while(true){
            try{
                lottoCount = getLottoCount();
            }catch(IllegalArgumentException e){
                continue;
            }
            break;
        }
    }

    private int getLottoCount() throws IllegalArgumentException{
        try {
            customerPrice = InputController.inputPrice();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_PRICE_MESSAGE.toString());
        }

        return parseLottoCount(customerPrice);
    }

    private int parseLottoCount(int customerPrice) throws IllegalArgumentException{
        if (customerPrice % LottoValues.LOTTO_PRICE != 0) {
            throw new IllegalStateException(ErrorMessage.ERROR_INPUT_PRICE_MESSAGE.toString());
        }
        return customerPrice / LottoValues.LOTTO_PRICE;
    }
}
