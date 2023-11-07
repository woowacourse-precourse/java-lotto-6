package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoAnswerService;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.service.UserService;

public class Application {
    public static void main(String[] args) {
        LottoAnswerService lottoAnswerService = new LottoAnswerService();
        LottoService lottoService = new LottoService();
        ResultService resultService = new ResultService();
        UserService userService = new UserService();

        LottoController lottoController = new LottoController(
                lottoAnswerService, lottoService,
                resultService, userService
        );

        lottoController.start();

    }
}
