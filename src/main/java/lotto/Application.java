package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new Output(), new Input(), new LottoService());
        lottoController.run();

    }
}
