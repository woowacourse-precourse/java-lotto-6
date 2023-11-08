package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.views.InputView;
import lotto.views.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new LottoService(), new InputView(), new OutputView());
        lottoController.run();
    }
}
