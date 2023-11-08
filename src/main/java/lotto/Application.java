package lotto;

import lotto.controller.LottoGameController;
import lotto.model.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        LottoGameController lottoGameController = new LottoGameController(game);
        lottoGameController.start();
    }
}
