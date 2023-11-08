package lotto.config;

import lotto.controller.GameController;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoStore;
import lotto.io.InputReader;
import lotto.io.OutputWriter;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConfig {

    public GameController getGameController() {
        Writer writer = getWriter();
        Reader reader = getReader();
        InputView inputView = getInputView(writer, reader);
        OutputView outputView = getOutputView(writer);
        LottoNumberGenerator lottoNumberGenerator = getLottoNumberGenerator();
        LottoStore lottoStore = getLottoStore(lottoNumberGenerator);
        return new GameController(inputView, outputView, lottoStore);
    }

    private Reader getReader() {
        return new InputReader();
    }

    private Writer getWriter() {
        return new OutputWriter();
    }

    private InputView getInputView(Writer writer, Reader reader) {
        return new InputView(writer, reader);
    }

    private OutputView getOutputView(Writer writer) {
        return new OutputView(writer);
    }

    private LottoNumberGenerator getLottoNumberGenerator() {
        return new LottoNumberGenerator();
    }

    private LottoStore getLottoStore(LottoNumberGenerator lottoNumberGenerator) {
        return new LottoStore(lottoNumberGenerator);
    }
}
