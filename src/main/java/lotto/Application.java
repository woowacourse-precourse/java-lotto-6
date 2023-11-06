package lotto;

import lotto.domain.LotteryController;

public class Application {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController();
        lotteryController.runGame();
    }
}
