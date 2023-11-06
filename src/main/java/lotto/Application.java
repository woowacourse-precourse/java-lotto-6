package lotto;

import lotto.domain.Game;
import lotto.utils.Reader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Game game = new Game();
            game.loadLottoMachine();
            game.joinPlayer();
            game.promptWinningLotto();
            game.calculateResult();
        } finally {
            Reader.close();
        }
    }
}
