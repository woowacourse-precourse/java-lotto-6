package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
