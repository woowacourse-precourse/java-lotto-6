package lotto.common;

import lotto.controller.LottoController;
import lotto.domain.LottoShop;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoControllerFactory {

    public LottoController getLottoController() {
        return new LottoController(new InputView(), new OutputView(), getLottoService());
    }

    private LottoService getLottoService() {
        return new LottoService(new LottoShop());
    }
}
