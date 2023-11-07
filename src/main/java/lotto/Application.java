package lotto;

import lotto.contoller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.runGame();
    }
}
