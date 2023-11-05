package lotto.config;

import java.util.List;
import lotto.controller.GameController;
import lotto.controller.InputController;
import lotto.domain.Player;
import lotto.domain.WinningNumbers;
import lotto.service.LottoGenerator;
import lotto.service.PlayerService;
import lotto.service.WinningLottoCalculator;

public class GameConfig {

    private static final int LOTTO_PRICE = 1000;

    public GameController getGameController() {
        PlayerService playerService = getPlayerService();
        int lottoCount = getLottoCount();

        return new GameController(playerService, lottoCount);
    }

    private WinningLottoCalculator getWinningLottoCalculator() {
        List<Integer> numbers = InputController.inputWinningNumber();
        int bonusNumber = InputController.inputBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        return new WinningLottoCalculator(winningNumbers);
    }

    private PlayerService getPlayerService() {
        Player player = new Player();
        LottoGenerator lottoGenerator = new LottoGenerator();
        WinningLottoCalculator winningLottoCalculator = getWinningLottoCalculator();

        return new PlayerService(player, lottoGenerator, winningLottoCalculator);
    }

    private int getLottoCount() {
        int customerPrice = InputController.inputPrice();

        return customerPrice/LOTTO_PRICE;
    }
}
