package lotto;

import lotto.domain.Game;
import lotto.utils.Reader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Game game = new Game();
            game.joinPlayer();
            game.issueLotto();
            game.drawWinningLotto();
            game.findResult();
        } finally {
            Reader.close();
        }
    }
}
