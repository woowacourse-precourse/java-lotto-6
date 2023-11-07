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
        setLottoCount();
        playerService.buy(lottoCount);
        outputController.printLottoPapers(player.getLottoPapers(), lottoCount);

        playerService.check(winningNumberGenerator.generate());
        outputController.printWinningStatistics(customerPrice);
    }

    private void setLottoCount() {
        while(true){
            try{
                customerPrice = InputController.inputPrice();
                lottoCount = parseLottoCount(customerPrice);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(ErrorMessage.ERROR_INPUT_PRICE_MESSAGE);
                System.out.println();
            }
        }
    }

    private int parseLottoCount(int customerPrice) throws IllegalArgumentException{
        if (canChangeCountByLottoPrice(customerPrice)) {
            throw new IllegalArgumentException();
        }
        return customerPrice / LottoValues.LOTTO_PRICE;
    }

    private static boolean canChangeCountByLottoPrice(int customerPrice) {
        return (customerPrice % LottoValues.LOTTO_PRICE != 0) || (customerPrice == 0);
    }
}
