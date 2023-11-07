package lotto;

import lotto.controller.LottoController;
import lotto.service.LotteryKiosk;
import lotto.service.LottoGenerator;

public class Application {

    private static final LottoGenerator lottoGenerator = new LottoGenerator();
    private static final LotteryKiosk lotteryKiosk = new LotteryKiosk(lottoGenerator);

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(lotteryKiosk);
        lottoController.run();
    }
}
