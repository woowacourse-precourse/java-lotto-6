package lotto.config;

import lotto.controller.LottoController;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.Reader;
import lotto.utils.Printer;
import lotto.utils.ReaderConsole;
import lotto.utils.SystemPrinter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public LottoController lottoController(){
        return new LottoController(outputView(), inputView(), lottoService());
    }

    private LottoService lottoService(){
        return new LottoService(winningLotto());
    }

    private Printer printer(){
        return new SystemPrinter();
    }

    private Reader reader(){
        return new ReaderConsole();
    }

    private InputView inputView(){
        return new InputView(printer(), reader());
    }

    private OutputView outputView(){
        return new OutputView(printer());
    }

    private WinningLotto winningLotto(){
        return WinningLotto.getInstance();
    }
}
