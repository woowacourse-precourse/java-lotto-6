package lotto;

import lotto.controller.LottoController;

public class Application {
    private static final LottoController game = new LottoController();
    public static void main(String[] args) {
        game.run();
    }
}
