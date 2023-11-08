package lotto;

import controller.LottoController;

public class Application {
    private static final LottoController lottoController = new LottoController();
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        lottoController.startGame();
    }
}
