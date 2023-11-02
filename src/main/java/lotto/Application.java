package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.Lotto;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        LottoGameController lottoGameController = new LottoGameController(lottoService);
        lottoGameController.run();
    }
}
