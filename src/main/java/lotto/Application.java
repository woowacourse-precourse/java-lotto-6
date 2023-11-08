package lotto;

import lotto.controller.Game;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.RandomLottoGenerator;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.start();
    }
}
