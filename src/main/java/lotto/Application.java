package lotto;

import lotto.controller.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoService lottoService = new LottoService(new InputView(), new OutputView());
        lottoService.run();
    }
}
