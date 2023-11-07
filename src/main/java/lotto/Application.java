package lotto;

import lotto.controller.LottoController;
import lotto.domain.UserLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    static LottoController lottoController = new LottoController(new LottoService(), new InputView(), new OutputView());

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoController.run();
    }
}
