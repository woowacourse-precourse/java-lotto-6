package lotto;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoGame;
import view.GameScreen;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameScreen gameScreen = new GameScreen();
        gameScreen.runGame();
    }
}
