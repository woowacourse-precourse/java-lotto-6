package lotto;

import lotto.controller.GameController;
import lotto.domain.Game;

public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController(new Game());
        controller.gameStart();
    }
}

