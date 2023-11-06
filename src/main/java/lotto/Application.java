package lotto;

import lotto.controller.Input;
import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.start.LottoGame;
import lotto.view.Exception;
import lotto.view.ExceptionView;
import lotto.view.LottoView;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output view = new LottoView();
        Exception exception = new ExceptionView();
        LottoService lottoService = new LottoService();
        Input controller = new LottoController(view,exception,lottoService);
        LottoGame lottoGame = new LottoGame(controller);

        lottoGame.run();
    }
}
