package lotto;

import lotto.controller.LottoController;
import lotto.domain.Player;
import lotto.domain.lotto.Lottos;
import lotto.domain.validate.InputValidator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

class Configuration {
    private Configuration() {
        throw new IllegalStateException("Utility class");
    }

    public static LottoController controller() {
        return new LottoController(lottoService(),new InputView(), new OutputView());
    }

    private static LottoService lottoService() {
        return new LottoService(new Player(), new Lottos(), new InputValidator());
    }
}
