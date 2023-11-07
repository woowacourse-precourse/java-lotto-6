package lotto;

import lotto.controller.LottoGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController gameController = new LottoGameController();
        gameController.run();
    }
}
