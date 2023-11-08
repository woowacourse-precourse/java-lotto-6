package lotto;

import lotto.controller.LottoController;
import lotto.model.ResultDetails;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoController(new InputView(), new OutputView(), new ResultDetails()).play();
    }
}
