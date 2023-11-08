package lotto;

import lotto.controllers.MainController;
import lotto.views.GameEnd;
import lotto.views.GameInit;
import lotto.views.GameOn;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameInit gameInit = new GameInit();
        GameOn gameOn = new GameOn();
        GameEnd gameEnd = new GameEnd();

        MainController gameController = new MainController(gameInit, gameOn, gameEnd);
        gameController.setLotto();
        gameController.checkNum();
        gameController.endGame();
    }
}
