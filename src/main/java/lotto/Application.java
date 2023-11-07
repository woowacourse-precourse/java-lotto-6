package lotto;

import lotto.controller.GameController;
import lotto.model.Game;
import lotto.model.LottoStore;
import lotto.util.Constants;
import lotto.util.RandomLottoGenerator;
import lotto.view.ConsoleView;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new ConsoleView();
        Game game = new Game(new LottoStore(Constants.LOTTO_PRICE, new RandomLottoGenerator()));
        GameController gameController = new GameController(view, game);

        gameController.run();
    }
}
