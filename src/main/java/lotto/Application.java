package lotto;

import lotto.controller.LottoGameController;
import lotto.util.LottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoGameController game = new LottoGameController(new LottoNumberGenerator());
        game.startGame();
    }
}
