package lotto.config;

import java.util.List;

import lotto.controller.LottoController;
import lotto.model.LottoMachine;
import lotto.model.LottoManager;
import lotto.util.generator.LottoNumberGenerator;
import lotto.util.generator.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationContainer {
    public LottoController getLottoController() {
        return new LottoController(getInputView(), getOutputView(), getLottoManager());
    }

    private LottoManager getLottoManager() {
        return new LottoManager(getLottoMachine());
    }

    private LottoMachine getLottoMachine() {
        return new LottoMachine(getNumberGenerator());
    }

    private NumberGenerator<List<Integer>> getNumberGenerator() {
        return new LottoNumberGenerator();
    }

    private InputView getInputView() {
        return InputView.getInstance();
    }

    private OutputView getOutputView() {
        return OutputView.getInstance();
    }
}
