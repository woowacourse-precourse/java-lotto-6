package lotto;

import lotto.domain.Game;
import lotto.domain.LottoMachine;
import lotto.domain.Prompter;
import lotto.utils.Reader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Game game = new Game(new Prompter(), new LottoMachine());
            game.joinPlayer();
            game.generateWinningLotto();
            game.calculateResult();
        } finally {
            Reader.close();
        }
    }
}
