package lotto;

import lotto.domain.Game;
import lotto.domain.WinningCalculator;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new WinningCalculator());
        game.start();
    }
}
