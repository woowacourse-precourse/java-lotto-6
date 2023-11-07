package lotto.common;

import lotto.controller.LottoController;
import lotto.domain.LottoShop;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Config {

    private Config() {
    }

    private static class LottoControllerHolder {
        private static final LottoController INSTANCE =
                new LottoController(new InputView(), new OutputView(), new LottoService(new LottoShop()));
    }

    public static LottoController getLottoController() {
        return LottoControllerHolder.INSTANCE;
    }
}
