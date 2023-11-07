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
                break;
            }catch(IllegalArgumentException e){
                System.out.println(ErrorMessage.ERROR_INPUT_PRICE_MESSAGE);
            }
        }
    }

    private int getLottoCount() throws IllegalArgumentException{
        try {
            customerPrice = InputController.inputPrice();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return parseLottoCount(customerPrice);
    }

    private int parseLottoCount(int customerPrice) throws IllegalArgumentException{
        if (customerPrice % LottoValues.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        return customerPrice / LottoValues.LOTTO_PRICE;
    }
}
