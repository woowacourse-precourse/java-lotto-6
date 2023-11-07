package lotto;

import lotto.controller.GameController;
import lotto.model.Game;
import lotto.view.ConsoleView;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new ConsoleView();
        Game game = new Game();
        GameController gameController = new GameController(view, game);

        gameController.run();
    }
}
