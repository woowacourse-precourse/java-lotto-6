package lotto.factory;

import lotto.controller.LottoController;
import lotto.io.OutputView;

public class ComponentFactory {

    public LottoController lottoController() {
        return new LottoController(outputView());
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
