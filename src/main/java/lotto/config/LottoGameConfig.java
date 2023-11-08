package lotto.config;

import lotto.controller.LottoGameController;
import lotto.service.LottoFactoryService;
import lotto.service.LottoResultCalculatorService;
import lotto.service.LottoStoreService;
import lotto.view.InputReader;
import lotto.view.InputView;
import lotto.view.OutputMessageResolver;
import lotto.view.OutputView;

public class LottoGameConfig {
    public InputView inputView() {
        return new InputView(inputReader());
    }

    public InputReader inputReader() {
        return new InputReader();
    }

    public OutputView outputView() {
        return new OutputView(messageResolver());
    }

    public OutputMessageResolver messageResolver() {
        return new OutputMessageResolver();
    }

    public LottoResultCalculatorService lottoRankCalculatorService() {
        return new LottoResultCalculatorService();
    }

    public LottoFactoryService lottoGeneratorService() {
        return new LottoFactoryService();
    }

    public LottoStoreService lottoStoreService() {
        return new LottoStoreService(lottoGeneratorService());
    }

    public LottoGameController lottoGameController() {
        return new LottoGameController(inputView(), outputView(), lottoStoreService(), lottoRankCalculatorService());
    }
}
