package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        UserService userService = new UserService();

        LottoController lottoController = new LottoController(inputView, outputView, lottoService, userService);

        lottoController.run();
    }
}
