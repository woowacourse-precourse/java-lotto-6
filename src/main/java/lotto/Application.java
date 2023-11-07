package lotto;

import lotto.controller.LottoGameController;
import lotto.generator.RandomNumbersGenerator;
import lotto.handler.InfiniteRetryExceptionHandler;
import lotto.service.LottoGameService;
import lotto.view.LottoGameConsoleView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(
                new LottoGameService(new RandomNumbersGenerator()),
                new LottoGameConsoleView(),
                new InfiniteRetryExceptionHandler());
        lottoGameController.run();
    }
}
