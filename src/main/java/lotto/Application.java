package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.exception.exceptionhandler.ExceptionHandler;
import lotto.exception.exceptionhandler.RetryExceptionHandler;
import lotto.model.LottoStore;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.lottogenerator.LottoGenerator;
import lotto.model.domain.lotto.lottogenerator.RandomLottoGenerator;

public class Application {
    public static void main(String[] args) {
        ExceptionHandler handler = new RetryExceptionHandler();
        LottoGenerator<Lotto> generator = new RandomLottoGenerator();
        LottoStore lottoStore = new LottoStore(generator);
        LottoController controller = new LottoController(handler, lottoStore);

        controller.run();
        Console.close();
    }
}
