package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = new LottoController(
                appConfig.getOrderLottoServiceInstance(),
                appConfig.getSelectWinningLottoServiceInstance(),
                appConfig.getCalculateLotteryServiceInstance()
        );

        lottoController.proceed();
    }
}
