package lotto;

import lotto.controller.LotteryController;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LotteryController lotteryController = new LotteryController();
        lotteryController.lottoGameStart();

    }
}
