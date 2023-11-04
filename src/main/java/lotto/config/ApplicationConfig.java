package lotto.config;

import lotto.controller.LottoController;
import lotto.exceptionhandler.ExceptionHandler;
import lotto.exceptionhandler.RetryExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.lottogenerator.LottoGenerator;
import lotto.model.lottogenerator.RandomLottoGenerator;
import lotto.view.LottoGameUI;
import lotto.view.TerminalUI;

public class ApplicationConfig {

    public final static ExceptionHandler handler = new RetryExceptionHandler();
    public final static LottoGenerator generator = new RandomLottoGenerator();
    public final static LottoStore lottoStore = new LottoStore(generator);
    public final static LottoGameUI ui = new TerminalUI();
    public final static LottoController controller = new LottoController(handler, lottoStore, ui);

    private ApplicationConfig(){ }
}
