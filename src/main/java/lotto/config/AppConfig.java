package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.utils.Printer;
import lotto.utils.SystemPrinter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public LottoController lottoController(){
        return new LottoController(outputView(), inputView(), lottoService());
    }

    private LottoService lottoService(){
        return new LottoService();
    }

    private Printer printer(){
        return new SystemPrinter();
    }

    private InputView inputView(){
        return new InputView(printer());
    }

    private OutputView outputView(){
        return new OutputView(printer());
    }

}
