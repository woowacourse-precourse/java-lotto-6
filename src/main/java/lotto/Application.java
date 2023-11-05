package lotto;

import lotto.controller.GameController;
import lotto.domain.Game;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController controller = new GameController(new Game());
        controller.gameStart();
    }
}

