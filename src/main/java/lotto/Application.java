package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(InputView.getInstance(), OutputView.getInstance(),
                LottoService.getInstance());
        lottoController.play();
    }
}
