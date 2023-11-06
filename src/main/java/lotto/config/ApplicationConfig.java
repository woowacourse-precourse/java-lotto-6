package lotto.config;

import lotto.controller.LottoController;
import lotto.exception.exceptionhandler.ExceptionHandler;
import lotto.exception.exceptionhandler.RetryExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.domain.lotto.lottogenerator.LottoGenerator;
import lotto.model.domain.lotto.lottogenerator.RandomLottoGenerator;

public class ApplicationConfig {

    public final static ExceptionHandler handler = new RetryExceptionHandler();
    public final static LottoGenerator generator = new RandomLottoGenerator();
    public final static LottoStore lottoStore = new LottoStore(generator);
    public final static LottoController controller = new LottoController(handler, lottoStore);

    private ApplicationConfig() {
    }
}
