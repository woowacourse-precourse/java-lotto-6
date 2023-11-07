package lotto;

import lotto.controller.LottoController;
import lotto.model.Input;
import lotto.model.LottoUtil;
import lotto.model.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new Input(), new LottoUtil(),
                new InputView(), new OutputView(), new RandomGenerator());
        lottoController.run();
    }
}
