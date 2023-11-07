package lotto.config;

import lotto.controller.LottoGameController;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoRankCalculatorService;
import lotto.service.LottoStoreService;
import lotto.view.InputReader;
import lotto.view.InputView;
import lotto.view.MessageResolver;
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

    public MessageResolver messageResolver() {
        return new MessageResolver();
    }

    public LottoRankCalculatorService lottoRankCalculatorService() {
        return new LottoRankCalculatorService();
    }

    public LottoGeneratorService lottoGeneratorService() {
        return new LottoGeneratorService();
    }

    public LottoStoreService lottoStoreService() {
        return new LottoStoreService(lottoGeneratorService());
    }

    public LottoGameController lottoGameController() {
        return new LottoGameController(inputView(), outputView(), lottoStoreService(), lottoRankCalculatorService());
    }
}
