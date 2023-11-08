package lotto;

import lotto.controller.lottomainservice.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        LottoService lottoService = appConfig.getLottoService();
        lottoService.game();
    }
}
