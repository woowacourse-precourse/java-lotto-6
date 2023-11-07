package lotto.configuration;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.NumberGenerator;
import lotto.service.RandomNumberGenerator;
import lotto.view.ConsoleInputDevice;
import lotto.view.ConsoleOutputDevice;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.Readable;
import lotto.view.Writable;

public class AppConfig {
    private static AppConfig appConfig;
    private LottoController lottoController;
    private LottoService lottoService;
    private NumberGenerator numberGenerator;
    private InputView inputView;
    private Readable inputDevice;
    private OutputView outputView;
    private Writable outputDevice;

    public static AppConfig getInstance() {
        if (appConfig == null) {
            return new AppConfig();
        }
        return appConfig;
    }

    public LottoController lottoController() {
        if (lottoController == null) {
            lottoController = new LottoController(lottoService(), inputView(), outputView());
        }
        return lottoController;
    }

    public LottoService lottoService() {
        if (lottoService == null) {
            lottoService = new LottoService(numberGenerator());
        }
        return lottoService;
    }

    public NumberGenerator numberGenerator() {
        if (numberGenerator == null) {
            numberGenerator = new RandomNumberGenerator();
        }
        return numberGenerator;
    }

    public Readable readable() {
        if (inputDevice == null) {
            inputDevice = new ConsoleInputDevice();
        }
        return inputDevice;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView(readable());
        }
        return inputView;
    }

    public Writable writable() {
        if (outputDevice == null) {
            outputDevice = new ConsoleOutputDevice();
        }
        return outputDevice;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView(writable());
        }
        return outputView;
    }
}
