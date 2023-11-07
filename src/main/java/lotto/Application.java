package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGenerator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoController lottoController = new LottoController(new InputView(), new LottoGenerator());

        lottoController.draw();
    }
}
