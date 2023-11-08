package lotto;

import lotto.controller.LottoController;
import lotto.service.LotteryKiosk;

public class Application {
    private static final LotteryKiosk lotteryKiosk = new LotteryKiosk();

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(lotteryKiosk);
        lottoController.run();
    }
}
