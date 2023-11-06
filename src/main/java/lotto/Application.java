package lotto;

import lotto.View.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startGame();
    }
}
