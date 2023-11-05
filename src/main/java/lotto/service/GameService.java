package lotto.service;

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
        inputWinngngNumbers();
        GameOutput.printBlankLine();
        inputBonusNumbers();
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

    private void inputWinngngNumbers() {
        GameOutput.enterWinnigNumbersMessage();
        ExceptionHandler.retryUntilSuccess(() ->  game.setWinningNumbers(GameInput.enterWinningNumbers()));
    }

    private void inputBonusNumbers() {
        GameOutput.enterBonusNumberMessage();
        ExceptionHandler.retryUntilSuccess(() ->  game.setBonusNumber(GameInput.enterBonusNumbers()));
    }
}
