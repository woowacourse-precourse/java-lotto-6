package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.views.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new LottoService(), new InputView());
        lottoController.run();
    }
}
