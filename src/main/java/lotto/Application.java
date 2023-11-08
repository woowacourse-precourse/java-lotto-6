package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.ResultService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        ResultService resultService = new ResultService();

        LottoController lottoController = new LottoController(lottoService, resultService);

        lottoController.start();

    }
}
