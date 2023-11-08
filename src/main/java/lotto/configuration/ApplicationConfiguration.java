package lotto.configuration;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;
import lotto.service.YieldCalculator;
import lotto.service.numbergenerator.NumberGenerator;
import lotto.service.numbergenerator.SixUniqueNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.reader.ConsoleReader;
import lotto.view.reader.Reader;

public class ApplicationConfiguration {

    public LottoGameController lottoGameController() {
        return new LottoGameController(inputView(), outputView(), lottoGameService());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputView inputView() {
        return new InputView(reader());
    }

    private Reader reader() {
        return new ConsoleReader();
    }

    private LottoGameService lottoGameService() {
        return new LottoGameService(numberGenerator(), yieldCalculator());
    }

    private NumberGenerator numberGenerator() {
        return new SixUniqueNumberGenerator();
    }

    private YieldCalculator yieldCalculator() {
        return new YieldCalculator();
    }

}
