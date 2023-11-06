package lotto;

import lotto.controller.LottoGameController;

public class Application {

    private static final LottoGameController lottoGameController = new LottoGameController();
    public static void main(String[] args) {

        lottoGameController.run();

    }
}
