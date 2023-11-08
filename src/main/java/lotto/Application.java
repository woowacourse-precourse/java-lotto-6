package lotto;

import static lotto.utils.Console.close;

import lotto.controller.LottoGameController;

public class Application {

    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.start();

        close();
    }
}
