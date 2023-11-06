package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.draw.DrawingMachine;
import lotto.domain.draw.LottoStore;
import lotto.domain.draw.NumbersGenerator;
import lotto.domain.draw.RandomNumbersGenerator;
import lotto.io.input.Reader;
import lotto.io.input.StdReader;
import lotto.io.output.StdWriter;
import lotto.io.output.Writer;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Configuration {
    public static LottoController createLottoController() {
        StdReader reader = new Reader();
        StdWriter writer = new Writer();

        InputView inputView = new InputView(reader, writer);
        OutputView outputView = new OutputView(writer);

        NumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator(1, 45, 6);
        LottoStore lottoStore = new LottoStore(randomNumbersGenerator);
        DrawingMachine drawingMachine = new DrawingMachine();
        LottoRepository lottoRepository = new LottoRepository();
        LottoService lottoService = new LottoService(lottoStore, lottoRepository, drawingMachine);

        return new LottoController(inputView, outputView, lottoService);
    }

}
