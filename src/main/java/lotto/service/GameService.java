가package lotto.service;

import lotto.domain.Game;
import lotto.domain.Player;
import lotto.util.ExceptionHandler;
import lotto.view.GameInput;
import lotto.view.GameOutput;

public class GameService {
    private static Game game;
    private static Player player;

    public void start() {
        GameOutput.enterPurchaseAmoutMessage();
        game = ExceptionHandler.retryUntilSuccess(() -> new Game(GameInput.enterPurchaseAmout()));

        GameOutput.printBlankLine();

        player = new Player(game.lottoPurchaseCount());
        GameOutput.showPurchaseLottoNumber(player.lottos);
    }

    public void gameSetting() {
        GameOutput.enterWinnigNumbersMessage();
        game.setWinningNumbers(GameInput.enterWinningNumbers());

        GameOutput.printBlankLine();

        GameOutput.enterBonusNumberMessage();
        game.setBonusNumber(GameInput.enterBonusNumbers());
    }

    public void gameInProgress() {
        player.checkMatchWinningNumber(game.getWinningNumbers());
        player.checkMatchBonusNumber(game.getBonusNumber());
    }

    public void result() {
        GameOutput.lottoResultTitleMessage();
        GameOutput.lottoResultMessage();
        GameOutput.earningMessage(player.getEarningRate(game.receiveAmount));
    }
}
