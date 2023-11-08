package lotto.config;

import lotto.generator.LottoGenerator;
import lotto.controller.LottoGameController;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationConfig {

    public LottoGameController gameController() {
        return new LottoGameController(outputView(), inputView(), lottoGenerator(),lottoMachine());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputView inputView() {
        return new InputView();
    }

    private LottoGenerator lottoGenerator() {
        return new LottoGenerator();
    }

    private LottoMachine lottoMachine(){
        return new LottoMachine();
    }
}
