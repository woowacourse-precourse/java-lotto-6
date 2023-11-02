package lotto;

import lotto.controller.LottoController;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new InputViewImpl(), new OutputView());
        lottoController.run();
    }
}
