package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.generator.ComputerGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Configuration {

    public static LottoController lottoController() {
        return new LottoController(new InputView(),
                new OutputView(),
                lottoService());
    }

    public static LottoService lottoService() {
        NumberGenerator numberGenerator = new ComputerGenerator();

        return new LottoService(numberGenerator);
    }
}
