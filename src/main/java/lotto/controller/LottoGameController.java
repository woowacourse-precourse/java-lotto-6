package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Game;
import lotto.model.LottoGame;
import lotto.view.GameView;
import lotto.view.LottoGameView;

public class LottoGameController implements GameController {
    private final LottoGame game;
    private final LottoGameView gameView;
    private boolean playGame = true;

    public LottoGameController(Game game, GameView gameView) {
        this.game = (LottoGame) game;
        this.gameView = (LottoGameView) gameView;
    }

    @Override
    public void play() {
        while (playGame) {
            gameView.showInputRequiredMessage("purchasePrice");
            game.setLottoPurchaseAmount(Console.readLine());
            game.createLottoTickets();
            gameView.showProgressOf(game);
            gameView.showInputRequiredMessage("winning-numbers");
            game.setWinningLotto(Console.readLine());
            gameView.showInputRequiredMessage("bonus-number");
            game.setBonusNumber(Console.readLine());
            game.play();
            gameView.showResultOf(game);

            quitGame();
        }
    }

    @Override
    public void quitGame() {
        playGame = game.continues();
    }
}
