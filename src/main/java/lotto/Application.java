package lotto;

import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameController game = new LottoGameController();
        game.start();
    }


}
