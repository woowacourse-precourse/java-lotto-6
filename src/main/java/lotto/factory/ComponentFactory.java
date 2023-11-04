package lotto.factory;

import lotto.controller.LottoController;
import lotto.io.InputView;
import lotto.io.OutputView;

public class ComponentFactory {

    public LottoController lottoController() {
        return new LottoController(outputView(), inputView());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputView inputView() {
        return new InputView();
    }
}
