package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRandomService;
import lotto.domain.LottoSeller;
import lotto.domain.RandomService;
import lotto.domain.YieldCalculator;
import lotto.service.LottoService;
import lotto.view.ConsoleService;
import lotto.view.InputView;
import lotto.view.LottoConsoleService;
import lotto.view.OutputView;

public class ObjectFactory {

    public InputView inputView() {
        return new InputView(consoleService());
    }

    private ConsoleService consoleService() {
        return new LottoConsoleService();
    }

    public LottoController lottoController() {
        return new LottoController(lottoService(), outputView());
    }

    private LottoService lottoService() {
        return new LottoService(lottoSeller(), yieldCalculator());
    }

    private LottoSeller lottoSeller() {
        return new LottoSeller(lottoMachine());
    }

    private LottoMachine lottoMachine() {
        return new LottoMachine(randomService());
    }

    private RandomService randomService() {
        return new LottoRandomService();
    }

    private YieldCalculator yieldCalculator() {
        return new YieldCalculator();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
