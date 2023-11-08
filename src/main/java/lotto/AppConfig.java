package lotto;

import lotto.controller.LottoGameController;
import lotto.controller.LottoPurchaseService;
import lotto.controller.LottoResultService;

public class AppConfig {
    public static LottoGameController lottoGame() {
        return new LottoGameController(lottoPurchaseService(), lottoResultService());
    }

    private static LottoPurchaseService lottoPurchaseService() {
        return new LottoPurchaseService();
    }

    private static LottoResultService lottoResultService() {
        return new LottoResultService();
    }
}
